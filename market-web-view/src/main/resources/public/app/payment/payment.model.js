"use strict";
var Payment = (function () {
    function Payment() {
        this.name = '';
        this.number = '';
        this.monthExpiration = '';
        this.yearExpiration = '';
        this.securityCode = '';
        this.installments = 1;
        this.hash = '';
    }
    return Payment;
}());
exports.Payment = Payment;
//# sourceMappingURL=payment.model.js.map