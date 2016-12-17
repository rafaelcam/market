import {Component} from "@angular/core";
import {CartService} from "../cart/cart.service";
import {Product} from "../product/product.model";
import {ItemCart} from "../cart/item.cart.model";

@Component({
    selector: 'checkout-cart',
    templateUrl: '../partials/checkout/checkout-cart.html'
})
export class CheckoutCartComponent {

    cart: string = 'cart';
    codeDiscount: string = "";

    constructor(public cartService: CartService) { }

    increaseProduct(item: ItemCart): void {
        this.cartService.addItem(item.product);
    }

    decreaseProduct(item: ItemCart): void {
        this.cartService.decreaseItem(item);
    }

    applyDiscount(): void {
        this.cartService.calculateDiscount(this.codeDiscount);
    }

}
