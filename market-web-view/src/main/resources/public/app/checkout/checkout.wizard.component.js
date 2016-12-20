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
var CheckoutWizardComponent = (function () {
    function CheckoutWizardComponent() {
        this.cartClass = 'step';
        this.infoClass = 'step';
        this.paymentClass = 'step';
        this.completeClass = 'step';
    }
    CheckoutWizardComponent.prototype.ngOnInit = function () {
        this.chooseClass();
    };
    CheckoutWizardComponent.prototype.chooseClass = function () {
        switch (this.activeSection) {
            case 'cart':
                this.cartClass = 'step active';
                break;
            case 'info':
                this.infoClass = 'step active';
                break;
            case 'payment':
                this.paymentClass = 'step active';
                break;
            case 'complete':
                this.completeClass = 'step active';
                break;
        }
    };
    __decorate([
        core_1.Input('activeSection'), 
        __metadata('design:type', String)
    ], CheckoutWizardComponent.prototype, "activeSection", void 0);
    CheckoutWizardComponent = __decorate([
        core_1.Component({
            selector: 'checkout-wizard',
            templateUrl: '../partials/checkout/checkout-wizard.html'
        }), 
        __metadata('design:paramtypes', [])
    ], CheckoutWizardComponent);
    return CheckoutWizardComponent;
}());
exports.CheckoutWizardComponent = CheckoutWizardComponent;
//# sourceMappingURL=checkout.wizard.component.js.map