export class Payment {
    name: string;
    number: string;
    monthExpiration: string;
    yearExpiration: string;
    securityCode: string;
    installments: number;
    hash: string;

    constructor() {
        this.name = '';
        this.number = '';
        this.monthExpiration = '';
        this.yearExpiration = '';
        this.securityCode = '';
        this.installments = 1;
        this.hash = '';
    }
}
