import {Injectable} from "@angular/core";
import {Customer} from "./customer.model";

@Injectable()
export class CustomerService {

    customer: Customer;

    constructor() {
        this.customer = new Customer();
    }

    clearCustomer(): void {
        this.customer = new Customer();
    }
}