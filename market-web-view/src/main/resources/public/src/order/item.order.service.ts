import {Injectable} from "@angular/core";
import {Order} from "./order.model";
import {Product} from "../product/product.model";
import {ItemOrder} from "./item.order.model";

@Injectable()
export class ItemOrderService {

    constructor() {
    }

    createNewItem(product: Product): ItemOrder {
        return new ItemOrder(product, 1, product.price);
    }

    increaseExistingItem(item: ItemOrder): void {
        item.quantity++;
        this.calculateTotalItem(item);
    }

    private calculateTotalItem(item: ItemOrder): void {
        item.totalItem = item.product.price*item.quantity;
    }
}