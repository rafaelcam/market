import {Component, OnInit} from "@angular/core";
import {Product} from "./product.model";
import {CartService} from "../cart/cart.service";
import {ProductService} from "./product.service";

@Component({
    selector: 'product-list',
    templateUrl: '../partials/product/list.html'
})
export class ProductListComponent implements OnInit{

    products: Product[];

    ngOnInit(): void {
        this.findAllProducts();
    }

    constructor(public cartService: CartService,
                public productService: ProductService) { }

    addProductCart(product: Product): void {
        this.cartService.addItem(product);
    }

    findAllProducts(): void {
        this.productService.findAll()
            .subscribe(res => {
                this.products = res;
            }, error => {
                console.log('Ocorreu um erro ao tentar buscar os produtos.')
            });
    }
}
