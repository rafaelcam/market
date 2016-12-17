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
var cart_model_1 = require("./cart.model");
var item_cart_service_1 = require("./item.cart.service");
var CartService = (function () {
    function CartService(itemCartService) {
        this.itemCartService = itemCartService;
        this.cart = new cart_model_1.Cart();
    }
    CartService.prototype.addItem = function (product) {
        var itemExisting = this.cartHaveItem(product);
        if (!itemExisting) {
            this.addNewItem(product);
        }
        else {
            this.addExistingItem(itemExisting);
        }
        this.calculateTotalCart();
    };
    CartService.prototype.removeItem = function (item) {
        var remove = this.cart.items.indexOf(item);
        this.cart.items.splice(remove, 1);
        this.calculateTotalCart();
    };
    CartService.prototype.decreaseItem = function (item) {
        if (item.quantity !== 1) {
            item.quantity--;
            this.itemCartService.calculateTotalItem(item);
            this.calculateTotalCart();
        }
    };
    CartService.prototype.clearCart = function () {
        this.cart = new cart_model_1.Cart();
    };
    CartService.prototype.calculateDiscount = function (code) {
        var percentage = this.findDiscountByCode(code);
        this.cart.discount = this.cart.totalCart * (percentage / 100);
    };
    CartService.prototype.addNewItem = function (product) {
        var item = this.itemCartService.createNewItem(product);
        this.cart.items.push(item);
    };
    CartService.prototype.addExistingItem = function (item) {
        this.itemCartService.increaseExistingItem(item);
    };
    CartService.prototype.cartHaveItem = function (product) {
        for (var _i = 0, _a = this.cart.items; _i < _a.length; _i++) {
            var item = _a[_i];
            if (item.product.name === product.name) {
                return item;
            }
        }
        return null;
    };
    CartService.prototype.calculateTotalCart = function () {
        this.cart.totalCart = 0.0;
        for (var _i = 0, _a = this.cart.items; _i < _a.length; _i++) {
            var item = _a[_i];
            this.cart.totalCart += item.totalItem;
        }
    };
    CartService.prototype.findDiscountByCode = function (code) {
        if (code === 'APPLEMARKET05') {
            return 5;
        }
        return 0;
    };
    return CartService;
}());
CartService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [item_cart_service_1.ItemCartService])
], CartService);
exports.CartService = CartService;
//# sourceMappingURL=cart.service.js.map