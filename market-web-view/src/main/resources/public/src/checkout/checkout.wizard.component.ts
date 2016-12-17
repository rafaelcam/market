import {Component, Input, OnInit} from "@angular/core";

@Component({
    selector: 'checkout-wizard',
    templateUrl: '../partials/checkout/checkout-wizard.html'
})
export class CheckoutWizardComponent implements OnInit {
    @Input('activeSection') activeSection: string;

    ngOnInit(): void {
        this.chooseClass();
    }

    cartClass: string = 'step';
    infoClass: string = 'step';
    paymentClass: string = 'step';
    completeClass: string = 'step';

    chooseClass(): void {
        switch (this.activeSection)
        {
            case'cart':
                this.cartClass = 'step active';
                break;
            case'info':
                this.infoClass = 'step active';
                break;
            case'payment':
                this.paymentClass = 'step active';
                break;
            case'complete':
                this.completeClass = 'step active';
                break;
        }
    }

}
