"use strict";
var Order = (function () {
    function Order(cart, customer, payment) {
        this.number = null;
        this.cart = cart;
        this.customer = customer;
        this.payment = payment;
    }
    return Order;
}());
exports.Order = Order;
//# sourceMappingURL=order.model.js.map