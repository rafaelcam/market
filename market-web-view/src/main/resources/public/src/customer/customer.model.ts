export class Customer {
    name: string;
    email: string;
    dataNascimento: Date;
    phone: string;
    address: string;

    constructor() {
        this.name = '';
        this.email = '';
        this.dataNascimento = new Date();
        this.phone = '';
        this.address = '';
    }
}
