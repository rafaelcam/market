import {Injectable} from "@angular/core";
import {Product} from "../product/product.model";
import {ItemCart} from "./item.cart.model";

@Injectable()
export class ItemCartService {

    constructor() {
    }

    createNewItem(product: Product): ItemCart {
        return new ItemCart(product, 1, product.price);
    }

    increaseExistingItem(item: ItemCart): void {
        item.quantity++;
        this.calculateTotalItem(item);
    }

    calculateTotalItem(item: ItemCart): void {
        item.totalItem = item.product.price*item.quantity;
    }
}