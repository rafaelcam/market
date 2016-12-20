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
var payment_model_1 = require("./payment.model");
var PaymentService = (function () {
    function PaymentService() {
        this.publicKey = "-----BEGIN PUBLIC KEY-----" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAixGsuDRnPjtGClguuPSM" +
            "a2nwQKdTxr4mTRy71a+jVnDRwFPADOscauPLreqUL8esjJBF3O9TzazM9TmI+ECA" +
            "6jKGbxh/t39HkRYmMCtXmDLbbXXQutCYyXOYdyx3cMxYaEeaFVuTCtPSiv9YYS4e" +
            "Jw6K/qO34qq0Xd7g66bXK4CXW8Um8+zOOhJfx6Cn01uasMQdagglUGxoVst9nNEa" +
            "Ts+zH4pe5K894C4PBsed6/XvmaaXAU4976WNLd2IY23geFFwa/dCajRT4/bRz3YH" +
            "fyxVwUG7JVdTVxvVBTAxjdXoJb08T5v+TO7hQjAkMO2l2drws1xMepsYswbHrnnU" +
            "6QIDAQAB" +
            "-----END PUBLIC KEY-----";
        this.payment = new payment_model_1.Payment();
    }
    PaymentService.prototype.encryptCard = function () {
        var card = new Moip.CreditCard({
            number: this.payment.number,
            cvc: this.payment.securityCode,
            expMonth: this.payment.monthExpiration,
            expYear: this.payment.yearExpiration,
            pubKey: this.publicKey
        });
        if (card.isValid()) {
            this.payment.hash = card.hash();
            return true;
        }
        else {
            return false;
        }
    };
    PaymentService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], PaymentService);
    return PaymentService;
}());
exports.PaymentService = PaymentService;
//# sourceMappingURL=payment.service.js.map