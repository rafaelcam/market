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
var order_model_1 = require("./order.model");
var item_order_service_1 = require("./item.order.service");
var OrderService = (function () {
    function OrderService(itemOrderService) {
        this.itemOrderService = itemOrderService;
        this.order = new order_model_1.Order();
    }
    OrderService.prototype.addItem = function (product) {
        var itemExisting = this.orderHaveItem(product);
        if (!itemExisting) {
            this.addNewItem(product);
        }
        else {
            this.addExistingItem(itemExisting);
        }
    };
    OrderService.prototype.removeItem = function (item) {
        var remove = this.order.items.indexOf(item);
        this.order.items.splice(remove, 1);
    };
    OrderService.prototype.addNewItem = function (product) {
        var item = this.itemOrderService.createNewItem(product);
        this.order.items.push(item);
    };
    OrderService.prototype.addExistingItem = function (item) {
        this.itemOrderService.increaseExistingItem(item);
    };
    OrderService.prototype.orderHaveItem = function (product) {
        for (var _i = 0, _a = this.order.items; _i < _a.length; _i++) {
            var item = _a[_i];
            if (item.product.name === product.name) {
                return item;
            }
        }
        return null;
    };
    OrderService.prototype.calculateTotalOrder = function () {
        this.order.totalOrder = 0.0;
        for (var _i = 0, _a = this.order.items; _i < _a.length; _i++) {
            var item = _a[_i];
            this.order.totalOrder += item.totalItem;
        }
    };
    OrderService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [item_order_service_1.ItemOrderService])
    ], OrderService);
    return OrderService;
}());
exports.OrderService = OrderService;
//# sourceMappingURL=order.service.js.map