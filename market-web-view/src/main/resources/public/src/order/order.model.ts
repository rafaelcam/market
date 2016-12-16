
import {ItemOrder} from "./item.order.model";

export class Order {
    referenceNumber: string;
    items: Array<ItemOrder>;
    totalOrder: number;

    constructor() {
        this.referenceNumber = '';
        this.items = [];
        this.totalOrder = 0.0;
    }
}
