import {Component} from "@angular/core";
import {OrderService} from "./order.service";
@Component({
    selector: 'order-button',
    templateUrl: '../partials/order/order-button.html'
})
export class OrderButtonComponent {

    constructor(private orderService: OrderService) { }

    sendOrder(): void {
        this.orderService.checkout();
    }

}
