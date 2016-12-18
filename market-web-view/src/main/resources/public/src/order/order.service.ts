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

    sendOrder(): void {
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
}