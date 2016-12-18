import {Component} from "@angular/core";
import {PaymentService} from "../payment/payment.service";
import {CartService} from "../cart/cart.service";

@Component({
    selector: 'checkout-info',
    templateUrl: '../partials/checkout/checkout-payment.html'
})
export class CheckoutPaymentComponent {

    payment: string = 'payment';
    installments: number[];

    constructor(public paymentService: PaymentService,
                public cartService: CartService) {  }


}
