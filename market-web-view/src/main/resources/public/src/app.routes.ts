import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import {EmailComponent} from "./email/email.component";
import {ProductListComponent} from "./product/product.list.component";
import {CheckoutCartComponent} from "./checkout/checkout.cart.component";

// Route Configuration
export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'email', component: EmailComponent },
    { path: 'product/list', component: ProductListComponent },
    { path: 'checkout/cart', component: CheckoutCartComponent }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);