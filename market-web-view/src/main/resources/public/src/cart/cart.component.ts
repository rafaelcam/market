import { Component } from '@angular/core';
import {OrderService} from "../order/order.service";
@Component({
    selector: 'cart',
    templateUrl: '../partials/cart/cart.html'
})
export class CartComponent {

    constructor(public orderService: OrderService) { }


}
