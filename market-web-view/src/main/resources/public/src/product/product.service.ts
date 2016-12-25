import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {AppConfig} from "../config/app.config";

@Injectable()
export class ProductService {
    constructor(private http: Http) { }

    findAll(): Observable<any> {
        return this.http.get(AppConfig.API_ENDPOINT+"product/").map(res => res.json());
    }

}