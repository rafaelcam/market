"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var cart_service_1 = require("../cart/cart.service");
var ProductListComponent = (function () {
    function ProductListComponent(cartService) {
        this.cartService = cartService;
    }
    ProductListComponent.prototype.ngOnInit = function () {
        this.products = this.findAllProducts();
    };
    ProductListComponent.prototype.addProductCart = function (product) {
        this.cartService.addItem(product);
    };
    ProductListComponent.prototype.findAllProducts = function () {
        return [
            { name: 'iPhone 6s Plus', description: '3D Touch. 12MP photos. 4K video.', price: 649.00, image: 'assets/img/iphone.png' },
            { name: 'Apple TV', description: 'The future of television is here.', price: 599.00, image: 'assets/img/apple-tv.png' },
            { name: 'iPhone SE 32Gb', description: 'A big step for small.', price: 499.00, image: 'assets/img/iphone-se.png' },
            { name: 'Apple Watch Sport Edition', description: 'You. At a glance.', price: 399.00, image: 'assets/img/apple-watch.png' },
            { name: '21.5-inch iMac', description: 'Retina. Now in colossal and ginormous.', price: 599.00, image: 'assets/img/imac.png' },
            { name: 'MacBook Pro', description: 'Stunning Retina Display', price: 99.00, image: 'assets/img/macbook-pro.png' },
            { name: '9.7-inch iPad Pro', description: '3D Touch. 12MP photos. 4K video.', price: 649.00, image: 'assets/img/ipad-pro.png' },
            { name: 'Mac Pro', description: 'Built for creativity on an epic scale.', price: 2999.00, image: 'assets/img/mac-pro.png' },
            { name: 'iPad Air 2', description: 'Light. Heavyweight.', price: 399.00, image: 'assets/img/ipad-air.png' }
        ];
    };
    return ProductListComponent;
}());
ProductListComponent = __decorate([
    core_1.Component({
        selector: 'product-list',
        templateUrl: '../partials/product/list.html'
    }),
    __metadata("design:paramtypes", [cart_service_1.CartService])
], ProductListComponent);
exports.ProductListComponent = ProductListComponent;
//# sourceMappingURL=product.list.component.js.map