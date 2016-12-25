import {Component, OnInit, OnDestroy} from "@angular/core";
import {OrderService} from "../order/order.service";
import {ActivatedRoute} from "@angular/router";
import {Order} from "../order/order.model";
import {Cart} from "../cart/cart.model";
import {Customer} from "../customer/customer.model";
import {Payment} from "../payment/payment.model";

@Component({
    selector: 'checkout-complete',
    templateUrl: '../partials/status/status-order.html'
})
export class StatusOrderComponent implements OnInit, OnDestroy  {

    order: Order;
    private sub: any;

    constructor(public orderService: OrderService,
                private route: ActivatedRoute) {
        this.order = new Order(new Cart(), new Customer(), new Payment());
    }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            var id = +params['id'];
            this.findOrderById(id);
        });

    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    private findOrderById(id: number): void {
        this.orderService.findById(id)
            .subscribe(res => {
                this.order = res;
            }, error => {
                alert('O número do pedido não foi encontrado em nossa Base de Dados.')
            });
    }

}
