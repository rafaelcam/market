import {Component} from "@angular/core";
import {PaymentService} from "../payment/payment.service";

@Component({
    selector: 'checkout-info',
    templateUrl: '../partials/checkout/checkout-payment.html'
})
export class CheckoutPaymentComponent {

    payment: string = 'payment';

    constructor(public paymentService: PaymentService) { }



}
