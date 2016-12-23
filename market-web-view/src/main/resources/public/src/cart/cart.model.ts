import {ItemCart} from "./item.cart.model";

export class Cart {
    items: Array<ItemCart>;
    discount: number;
    addition: number;
    totalCart: number;

    constructor() {
        this.items = [];
        this.totalCart = 0.0;
        this.discount = 0.0;
        this.addition = 0.0;
    }

    getTotal(): number {
        return ((this.totalCart-this.discount)+this.addition);
    }
}
