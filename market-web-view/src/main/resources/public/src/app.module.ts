import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from "@angular/http";

import { AppComponent }         from './app.component';
import { HomeComponent }        from './home/home.component';
import {routing} from "./app.routes";
import {EmailComponent} from "./email/email.component";
import {EmailService} from "./email/email.service";
import {ProductListComponent} from "./product/product.list.component";
import {CartComponent} from "./cart/cart.component";
import {CartService} from "./cart/cart.service";
import {ItemCartService} from "./cart/item.cart.service";
import {CheckoutCartComponent} from "./checkout/checkout.cart.component";
import {CheckoutWizardComponent} from "./checkout/checkout.wizard.component";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    EmailComponent,
    ProductListComponent,
    CartComponent,
    CheckoutCartComponent,
    CheckoutWizardComponent
  ],
  providers: [
    EmailService,
    CartService,
    ItemCartService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }