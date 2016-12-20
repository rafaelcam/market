import {Injectable} from "@angular/core";
import {Order} from "./order.model";
import {CartService} from "../cart/cart.service";
import {CustomerService} from "../customer/customer.service";
import {PaymentService} from "../payment/payment.service";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {MessageService} from "../message/message.service";

@Injectable()
export class OrderService {
    private url = 'http://localhost:8081/';
    order: Order;

    constructor(private messageService: MessageService,
                private http: Http,
                private cartService: CartService,
                private customerService: CustomerService,
                private paymentService: PaymentService) { }

    checkout(): void {
        if(!this.paymentService.encryptCard()) {
            this.messageService.loadErrorMessages([{message: "Cartão de crédito inválido, verifique os dados digitados."}]);
            return;
        }

        if(!this.validAndformatDate()) {
            this.messageService.loadErrorMessages([{message: "Data de Nascimento inválida, verifique os dados digitados."}]);
            return;
        }

        this.makeOrder();
        this.validateAndSendOrder();
    }

    private validateAndSendOrder(): void {
        this.callValidateOrder()
            .subscribe(res => {
                this.validateCustomer();
            }, error => {
                this.messageService.loadErrorMessages(error.json());
            });
    }

    private validateCustomer(): void {
        this.callValidateCustomer()
            .subscribe(res => {
                this.validatePayment();
            }, error => {
                this.messageService.loadErrorMessages(error.json());
            });
    }

    private validatePayment(): void {
        this.callValidatePayment()
            .subscribe(res => {
                this.sendOrderRequest();
            }, error => {
                this.messageService.loadErrorMessages(error.json());
            });
    }

    private sendOrderRequest(): void {
        this.callSendOrderRequest()
            .subscribe(res => {
                this.order = res;
            }, error => {
                console.log(error.json());
                this.messageService.loadErrorMessages(error.json());
            });
    }

    private callValidateOrder(): Observable<any> {
        return this.http.post(this.url+"orderbuy/isvalid", this.order).map(res => res);
    }

    private callValidateCustomer(): Observable<any> {
        return this.http.post(this.url+"customer/isvalid", this.order.customer).map(res => res);
    }

    private callValidatePayment(): Observable<any> {
        return this.http.post(this.url+"payment/isvalid", this.order.payment).map(res => res);
    }

    private callSendOrderRequest(): Observable<any> {
        return this.http.post(this.url+"orderbuy/", this.order).map(res => res.json());
    }

    private makeOrder(): void {
        this.order = new Order(
                this.cartService.cart,
                this.customerService.customer,
                this.paymentService.payment
            );
    }

    private validAndformatDate(): boolean {
        var date = this.customerService.customer.dateBirth;

        try {
            var parts = this.customerService.customer.dateBirth.split('/');

            if(parts.length !== 3) {
                throw new RangeError();
            }

            this.customerService.customer.dateBirth = parts[2]+'-'+parts[1]+'-'+parts[0];
            return true;
        }
        catch (e){
            return false;
        }
    }
}