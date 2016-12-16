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
var item_order_model_1 = require("./item.order.model");
var ItemOrderService = (function () {
    function ItemOrderService() {
    }
    ItemOrderService.prototype.createNewItem = function (product) {
        return new item_order_model_1.ItemOrder(product, 1, product.price);
    };
    ItemOrderService.prototype.increaseExistingItem = function (item) {
        item.quantity++;
        this.calculateTotalItem(item);
    };
    ItemOrderService.prototype.calculateTotalItem = function (item) {
        item.totalItem = item.product.price * item.quantity;
    };
    ItemOrderService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], ItemOrderService);
    return ItemOrderService;
}());
exports.ItemOrderService = ItemOrderService;
//# sourceMappingURL=item.order.service.js.map