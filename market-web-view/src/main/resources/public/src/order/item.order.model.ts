
import {Product} from "../product/product.model";

export class ItemOrder {
    product: Product;
    quantity: number;
    totalItem: number;

    constructor(product: Product, quantity: number, totalItem: number) {
        this.product = product;
        this.quantity = quantity;
        this.totalItem = totalItem;
    }
}
