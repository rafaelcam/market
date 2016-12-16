import {Injectable} from "@angular/core";
import {Order} from "./order.model";
import {Product} from "../product/product.model";
import {ItemOrder} from "./item.order.model";
import {ItemOrderService} from "./item.order.service";

@Injectable()
export class OrderService {

    order: Order;

    constructor(public itemOrderService: ItemOrderService) {
        this.order = new Order();
    }

    addItem(product: Product): void {
        var itemExisting = this.orderHaveItem(product);

        if(!itemExisting) {
            this.addNewItem(product);
        } else {
            this.addExistingItem(itemExisting);
        }
    }

    removeItem(item: ItemOrder): void {
        var remove = this.order.items.indexOf(item);
        this.order.items.splice(remove, 1);
    }

    private addNewItem(product: Product): void {
        var item = this.itemOrderService.createNewItem(product);
        this.order.items.push(item);
    }

    private addExistingItem(item: ItemOrder): void {
        this.itemOrderService.increaseExistingItem(item);
    }

    private orderHaveItem(product: Product): ItemOrder {
        for(let item of this.order.items) {
            if(item.product.name === product.name) {
                return item;
            }
        }
        return null;
    }

    private calculateTotalOrder(): void {
        this.order.totalOrder = 0.0;
        for(let item of this.order.items) {
            this.order.totalOrder += item.totalItem;
        }
    }
}