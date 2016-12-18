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
var cart_service_1 = require("../cart/cart.service");
var customer_service_1 = require("../customer/customer.service");
var payment_service_1 = require("../payment/payment.service");
var http_1 = require("@angular/http");
var OrderService = (function () {
    function OrderService(http, cartService, customerService, paymentService) {
        this.http = http;
        this.cartService = cartService;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.url = 'http://localhost:8081/';
    }
    OrderService.prototype.sendOrder = function () {
        var _this = this;
        this.makeOrder();
        this.callSendOrderRequest()
            .subscribe(function (res) {
            _this.order = res;
        }, function (error) {
            console.log('Ocorreu um erro ao tentar realizar o Pedido.');
        });
    };
    OrderService.prototype.callSendOrderRequest = function () {
        return this.http.post(this.url + "orderbuy/", this.order).map(function (res) { return res.json(); });
    };
    OrderService.prototype.makeOrder = function () {
        this.order = new order_model_1.Order(this.cartService.cart, this.customerService.customer, this.paymentService.payment);
    };
    return OrderService;
}());
OrderService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http,
        cart_service_1.CartService,
        customer_service_1.CustomerService,
        payment_service_1.PaymentService])
], OrderService);
exports.OrderService = OrderService;
//# sourceMappingURL=order.service.js.map