import {Injectable} from "@angular/core";
import {Product} from "../product/product.model";
import {Cart} from "./cart.model";
import {ItemCartService} from "./item.cart.service";
import {ItemCart} from "./item.cart.model";

@Injectable()
export class CartService {

    cart: Cart;

    constructor(public itemCartService: ItemCartService) {
        this.cart = new Cart();
    }

    addItem(product: Product): void {
        var itemExisting = this.cartHaveItem(product);

        if(!itemExisting) {
            this.addNewItem(product);
        } else {
            this.addExistingItem(itemExisting);
        }

        this.calculateTotalCart();
    }

    removeItem(item: ItemCart): void {
        var remove = this.cart.items.indexOf(item);
        this.cart.items.splice(remove, 1);
        this.calculateTotalCart();
    }

    decreaseItem(item: ItemCart): void {
       if(item.quantity !== 1) {
           item.quantity--;
           this.itemCartService.calculateTotalItem(item);
           this.calculateTotalCart();
       }
    }

    clearCart(): void {
        this.cart = new Cart();
    }

    calculateDiscount(code: string){
        var percentage = this.findDiscountByCode(code);
        this.cart.discount = this.cart.totalCart*(percentage/100);
    }

    private addNewItem(product: Product): void {
        var item = this.itemCartService.createNewItem(product);
        this.cart.items.push(item);
    }

    private addExistingItem(item: ItemCart): void {
        this.itemCartService.increaseExistingItem(item);
    }

    private cartHaveItem(product: Product): ItemCart {
        for(let item of this.cart.items) {
            if(item.product.name === product.name) {
                return item;
            }
        }
        return null;
    }

    private calculateTotalCart(): void {
        this.cart.totalCart = 0.0;
        for(let item of this.cart.items) {
            this.cart.totalCart += item.totalItem;
        }
    }

    private findDiscountByCode(code: string): number {
        if(code === 'APPLEMARKET05') {
            return 5;
        }
        return 0;
    }
}