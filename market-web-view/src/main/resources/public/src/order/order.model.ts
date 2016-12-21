import {Cart} from "../cart/cart.model";
import {Customer} from "../customer/customer.model";
import {Payment} from "../payment/payment.model";

export class Order {
    cart: Cart;
    customer: Customer;
    payment: Payment;

    constructor(cart: Cart, customer: Customer, payment: Payment) {
        this.cart = cart;
        this.customer = customer;
        this.payment = payment;
    }
}
