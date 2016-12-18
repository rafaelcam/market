import {NgModule, LOCALE_ID} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {HomeComponent} from "./home/home.component";
import {routing} from "./app.routes";
import {EmailComponent} from "./email/email.component";
import {EmailService} from "./email/email.service";
import {ProductListComponent} from "./product/product.list.component";
import {CartComponent} from "./cart/cart.component";
import {CartService} from "./cart/cart.service";
import {ItemCartService} from "./cart/item.cart.service";
import {CheckoutCartComponent} from "./checkout/checkout.cart.component";
import {CheckoutWizardComponent} from "./checkout/checkout.wizard.component";
import {CheckoutInfoComponent} from "./checkout/checkout.info.component";
import {CustomerService} from "./customer/customer.service";
import {CheckoutPaymentComponent} from "./checkout/checkout.payment.component";
import {PaymentService} from "./payment/payment.service";
import {ProductService} from "./product/product.service";
import {OrderService} from "./order/order.service";
import {OrderButtonComponent} from "./order/order.button.component";
import {MessageService} from "./message/message.service";
import {MessageComponent} from "./message/message.component";


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
    CheckoutWizardComponent,
    CheckoutInfoComponent,
    CheckoutPaymentComponent,
    OrderButtonComponent,
    MessageComponent
  ],
  providers: [
    { provide: LOCALE_ID, useValue: "pt-BR" },
    EmailService,
    CartService,
    ItemCartService,
    CustomerService,
    PaymentService,
    ProductService,
    OrderService,
    MessageService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }