import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {MessageService} from "../message/message.service";

@Component({
    selector: 'checkout-complete',
    templateUrl: '../partials/status/verify-order.html'
})
export class VerifyOrderComponent {

    numberOrder: number;

    constructor(private messageService: MessageService,
                private router: Router,) {
    }

    private verify(): void {
        if (!this.numberOrder) {
            this.messageService.loadErrorMessages([{message: "Número do pedido - Preenchimento Obrigatório."}]);
            return;
        }

        this.router.navigate(['status/order', this.numberOrder]);
    }

}
