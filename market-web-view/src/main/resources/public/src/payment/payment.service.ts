import {Injectable} from "@angular/core";
import {Payment} from "./payment.model";

@Injectable()
export class PaymentService {

    payment: Payment;

    constructor() {
        this.payment = new Payment();
    }
}