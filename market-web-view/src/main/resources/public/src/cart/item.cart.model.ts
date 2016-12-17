
import {Product} from "../product/product.model";

export class ItemCart {
    product: Product;
    quantity: number;
    totalItem: number;

    constructor(product: Product, quantity: number, totalItem: number) {
        this.product = product;
        this.quantity = quantity;
        this.totalItem = totalItem;
    }
}
