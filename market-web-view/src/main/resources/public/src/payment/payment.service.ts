declare var Moip: any;

import {Injectable} from "@angular/core";
import {Payment} from "./payment.model";

@Injectable()
export class PaymentService {

    payment: Payment;
    publicKey: string = "-----BEGIN PUBLIC KEY-----"+
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAixGsuDRnPjtGClguuPSM"+
        "a2nwQKdTxr4mTRy71a+jVnDRwFPADOscauPLreqUL8esjJBF3O9TzazM9TmI+ECA"+
        "6jKGbxh/t39HkRYmMCtXmDLbbXXQutCYyXOYdyx3cMxYaEeaFVuTCtPSiv9YYS4e"+
        "Jw6K/qO34qq0Xd7g66bXK4CXW8Um8+zOOhJfx6Cn01uasMQdagglUGxoVst9nNEa"+
        "Ts+zH4pe5K894C4PBsed6/XvmaaXAU4976WNLd2IY23geFFwa/dCajRT4/bRz3YH"+
        "fyxVwUG7JVdTVxvVBTAxjdXoJb08T5v+TO7hQjAkMO2l2drws1xMepsYswbHrnnU"+
        "6QIDAQAB"+
        "-----END PUBLIC KEY-----";

    constructor() {
        this.payment = new Payment();
    }

    encryptCard(): boolean {
        var card = new Moip.CreditCard({
            number  : this.payment.number,
            cvc     : this.payment.securityCode,
            expMonth: this.payment.monthExpiration,
            expYear : this.payment.yearExpiration,
            pubKey  : this.publicKey
        });

        if(card.isValid()) {
            this.payment.hash = card.hash();
            return true;
        } else {
            return false;
        }
    }
}