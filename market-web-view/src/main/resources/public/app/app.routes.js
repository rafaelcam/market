"use strict";
var router_1 = require('@angular/router');
var home_component_1 = require('./home/home.component');
var email_component_1 = require("./email/email.component");
var product_list_component_1 = require("./product/product.list.component");
// Route Configuration
exports.routes = [
    { path: '', component: home_component_1.HomeComponent },
    { path: 'email', component: email_component_1.EmailComponent },
    { path: 'product/list', component: product_list_component_1.ProductListComponent }
];
exports.routing = router_1.RouterModule.forRoot(exports.routes);
//# sourceMappingURL=app.routes.js.map