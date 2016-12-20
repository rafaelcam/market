import {Component} from "@angular/core";
import {CustomerService} from "../customer/customer.service";
import {CartService} from "../cart/cart.service";

declare var jQuery:any;

@Component({
    selector: 'checkout-info',
    templateUrl: '../partials/checkout/checkout-info.html'
})
export class CheckoutInfoComponent {

    info: string = 'info';

    constructor(public customerService: CustomerService,
                public cartService: CartService) {
    }

    mostraData(): void {
        console.log("Data: "+this.customerService.customer.dateBirth);
    }

}
