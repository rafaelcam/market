import { Injectable }    from '@angular/core';
import {Headers, Http, Response} from '@angular/http';
import 'rxjs/add/operator/map'

@Injectable()
export class EmailService {
    private url = 'http://localhost:9094/email/';  // URL to web api

    constructor(private http: Http) { }

    validarConsulta(email: any) {
        return this.http.post(this.url+"validarconsulta", email).map(res => res.json());
    }

    enviarEmails(email: any) {
        return this.http.post(this.url+"enviaremailpadrao", email).map(res => res);
    }
}