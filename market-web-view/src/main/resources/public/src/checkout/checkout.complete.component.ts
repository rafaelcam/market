import {Component} from "@angular/core";
import {OrderService} from "../order/order.service";
import {Router} from "@angular/router";

@Component({
    selector: 'checkout-complete',
    templateUrl: '../partials/checkout/checkout-complete.html'
})
export class CheckoutCompleteComponent {

    complete: string = 'complete';

    constructor(public orderService: OrderService,
        private router: Router) {  }

    navigateToStatusOrder(id: number): void {
        this.router.navigate(['/status/order', id]);
    }
}
