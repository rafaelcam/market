import {ItemCart} from "./item.cart.model";

export class Cart {
    referenceNumber: string;
    items: Array<ItemCart>;
    discount: number;
    totalCart: number;

    constructor() {
        this.referenceNumber = '';
        this.items = [];
        this.totalCart = 0.0;
        this.discount = 0.0;
    }
}
