import { Component } from '@angular/core';
import {Product} from "../product/product.model";
import {CartService} from "./cart.service";
@Component({
    selector: 'cart',
    templateUrl: '../partials/cart/cart.html'
})
export class CartComponent {

    constructor(public cartService: CartService) { }

}
