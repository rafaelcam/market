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
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms");
var http_1 = require("@angular/http");
var app_component_1 = require("./app.component");
var home_component_1 = require("./home/home.component");
var app_routes_1 = require("./app.routes");
var email_component_1 = require("./email/email.component");
var email_service_1 = require("./email/email.service");
var product_list_component_1 = require("./product/product.list.component");
var cart_component_1 = require("./cart/cart.component");
var cart_service_1 = require("./cart/cart.service");
var item_cart_service_1 = require("./cart/item.cart.service");
var checkout_cart_component_1 = require("./checkout/checkout.cart.component");
var checkout_wizard_component_1 = require("./checkout/checkout.wizard.component");
var checkout_info_component_1 = require("./checkout/checkout.info.component");
var customer_service_1 = require("./customer/customer.service");
var checkout_payment_component_1 = require("./checkout/checkout.payment.component");
var payment_service_1 = require("./payment/payment.service");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            forms_1.FormsModule,
            http_1.HttpModule,
            app_routes_1.routing
        ],
        declarations: [
            app_component_1.AppComponent,
            home_component_1.HomeComponent,
            email_component_1.EmailComponent,
            product_list_component_1.ProductListComponent,
            cart_component_1.CartComponent,
            checkout_cart_component_1.CheckoutCartComponent,
            checkout_wizard_component_1.CheckoutWizardComponent,
            checkout_info_component_1.CheckoutInfoComponent,
            checkout_payment_component_1.CheckoutPaymentComponent
        ],
        providers: [
            email_service_1.EmailService,
            cart_service_1.CartService,
            item_cart_service_1.ItemCartService,
            customer_service_1.CustomerService,
            payment_service_1.PaymentService
        ],
        bootstrap: [app_component_1.AppComponent]
    }),
    __metadata("design:paramtypes", [])
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map