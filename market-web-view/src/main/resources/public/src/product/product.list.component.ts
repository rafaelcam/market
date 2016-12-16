import {Component, OnInit} from '@angular/core';
import {Product} from "./product.model";
import {ItemOrderService} from "../order/item.order.service";
import {ItemOrder} from "../order/item.order.model";
import {OrderService} from "../order/order.service";
@Component({
    selector: 'product-list',
    templateUrl: '../partials/product/list.html'
})
export class ProductListComponent implements OnInit{

    products: Product[];

    ngOnInit(): void {
        this.products = this.findAllProducts();
    }

    constructor(public orderService: OrderService) { }

    findAllProducts(): Product[] {
        return [
            {name: 'iPhone 6s Plus', description: '3D Touch. 12MP photos. 4K video.', price: 649.00, image: 'assets/img/iphone.png'},
            {name: 'Apple TV', description: 'The future of television is here.', price: 599.00, image: 'assets/img/apple-tv.png'},
            {name: 'iPhone SE 32Gb', description: 'A big step for small.', price: 499.00, image: 'assets/img/iphone-se.png'},
            {name: 'Apple Watch Sport Edition', description: 'You. At a glance.', price: 399.00, image: 'assets/img/apple-watch.png'},
            {name: '21.5-inch iMac', description: 'Retina. Now in colossal and ginormous.', price: 599.00, image: 'assets/img/imac.png'},
            {name: 'MacBook Pro', description: 'Stunning Retina Display', price: 99.00, image: 'assets/img/macbook-pro.png'},
            {name: '9.7-inch iPad Pro', description: '3D Touch. 12MP photos. 4K video.', price: 649.00, image: 'assets/img/ipad-pro.png'},
            {name: 'Mac Pro', description: 'Built for creativity on an epic scale.', price: 2999.00, image: 'assets/img/mac-pro.png'},
            {name: 'iPad Air 2', description: 'Light. Heavyweight.', price: 399.00, image: 'assets/img/ipad-air.png'}
        ]
    }
}
