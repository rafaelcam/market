import {Injectable} from "@angular/core";
import {Order} from "./order.model";
import {CartService} from "../cart/cart.service";
import {CustomerService} from "../customer/customer.service";
import {PaymentService} from "../payment/payment.service";
import {Http} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class OrderService {
    private url = 'http://localhost:8081/';
    order: Order;

    constructor(private http: Http,
                private cartService: CartService,
                private customerService: CustomerService,
                private paymentService: PaymentService) { }

    sendOrder(): void {
        this.makeOrder();

        this.callSendOrderRequest()
            .subscribe(res => {
                this.order = res;
            }, error => {
                console.log('Ocorreu um erro ao tentar realizar o Pedido.')
            });
    }

    callSendOrderRequest(): Observable<any> {
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