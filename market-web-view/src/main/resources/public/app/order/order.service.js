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
var message_service_1 = require("../message/message.service");
var OrderService = (function () {
    function OrderService(messageService, http, cartService, customerService, paymentService) {
        this.messageService = messageService;
        this.http = http;
        this.cartService = cartService;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.url = 'http://localhost:8081/';
    }
    OrderService.prototype.sendOrder = function () {
        this.makeOrder();
        this.validateAndSendOrder();
    };
    OrderService.prototype.validateAndSendOrder = function () {
        var _this = this;
        this.callValidateOrder()
            .subscribe(function (res) {
            _this.validateCustomer();
        }, function (error) {
            _this.messageService.loadErrorMessages(error.json());
        });
    };
    OrderService.prototype.validateCustomer = function () {
        var _this = this;
        this.callValidateCustomer()
            .subscribe(function (res) {
            _this.validatePayment();
        }, function (error) {
            _this.messageService.loadErrorMessages(error.json());
        });
    };
    OrderService.prototype.validatePayment = function () {
        var _this = this;
        this.callValidatePayment()
            .subscribe(function (res) {
            _this.sendOrderRequest();
        }, function (error) {
            _this.messageService.loadErrorMessages(error.json());
        });
    };
    OrderService.prototype.sendOrderRequest = function () {
        var _this = this;
        this.callSendOrderRequest()
            .subscribe(function (res) {
            _this.order = res;
        }, function (error) {
            console.log(error.json());
            _this.messageService.loadErrorMessages(error.json());
        });
    };
    OrderService.prototype.callValidateOrder = function () {
        return this.http.post(this.url + "orderbuy/isvalid", this.order).map(function (res) { return res; });
    };
    OrderService.prototype.callValidateCustomer = function () {
        return this.http.post(this.url + "customer/isvalid", this.order.customer).map(function (res) { return res; });
    };
    OrderService.prototype.callValidatePayment = function () {
        return this.http.post(this.url + "payment/isvalid", this.order.payment).map(function (res) { return res; });
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
    __metadata("design:paramtypes", [message_service_1.MessageService,
        http_1.Http,
        cart_service_1.CartService,
        customer_service_1.CustomerService,
        payment_service_1.PaymentService])
], OrderService);
exports.OrderService = OrderService;
//# sourceMappingURL=order.service.js.map