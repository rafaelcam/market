import {Component} from "@angular/core";
import {CustomerService} from "../customer/customer.service";

@Component({
    selector: 'checkout-info',
    templateUrl: '../partials/checkout/checkout-info.html'
})
export class CheckoutInfoComponent {

    info: string = 'info';

    constructor(public customerService: CustomerService) { }



}
