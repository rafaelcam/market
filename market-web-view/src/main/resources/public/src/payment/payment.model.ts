export class Payment {
    name: string;
    number: string;
    monthExpiration: string;
    yearExpiration: string;
    securityCode: string;

    constructor() {
        this.name = '';
        this.number = '';
        this.monthExpiration = '';
        this.yearExpiration = '';
        this.securityCode = '';
    }
}
