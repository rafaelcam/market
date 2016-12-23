import {Injectable} from "@angular/core";
import {Order} from "./order.model";
import {CartService} from "../cart/cart.service";
import {CustomerService} from "../customer/customer.service";
import {PaymentService} from "../payment/payment.service";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {MessageService} from "../message/message.service";
import {Cart} from "../cart/cart.model";
import {Customer} from "../customer/customer.model";
import {Payment} from "../payment/payment.model";
import {Router} from "@angular/router";
import {SlimLoadingBarService} from "ng2-slim-loading-bar";

@Injectable()
export class OrderService {
    private url = 'http://ec2-54-187-197-124.us-west-2.compute.amazonaws.com:8081/';
    order: Order;
    orderComplete: Order;

    constructor(private messageService: MessageService,
                private http: Http,
                private cartService: CartService,
                private customerService: CustomerService,
                private paymentService: PaymentService,
                private router: Router,
                private loading: SlimLoadingBarService) {
        this.orderComplete = new Order(new Cart(), new Customer(), new Payment());
    }

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
        this.loading.start(() => {
            console.log('Loading complete');
        });

        this.callSendOrderRequest()
            .subscribe(res => {
                this.orderComplete = res;
                this.clearData();
                this.loading.complete();
                this.router.navigate(['checkout/complete']);
            }, error => {
                console.log(error.json());
                this.loading.complete();
                this.messageService.loadErrorMessages(error.json());
            });
    }

    private clearData(): void {
        this.paymentService.clearPayment();
        this.cartService.clearCart();
        this.customerService.clearCustomer();
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

    public findById(id: number): Observable<any> {
        return this.http.get(this.url+"orderbuy/"+id).map(res => res.json());
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