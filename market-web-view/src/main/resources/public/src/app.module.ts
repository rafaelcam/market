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
import {OrderService} from "./order/order.service";
import {ItemOrderService} from "./order/item.order.service";
import {CartComponent} from "./cart/cart.component";


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
    CartComponent
  ],
  providers: [
    EmailService,
    OrderService,
    ItemOrderService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }