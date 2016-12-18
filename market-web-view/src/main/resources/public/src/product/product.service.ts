import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Product} from "./product.model";
import {Observable} from "rxjs";

@Injectable()
export class ProductService {
    private url = 'http://localhost:8081/';  // URL to web api

    constructor(private http: Http) { }

    findAll(): Observable<any> {
        return this.http.get(this.url+"product/").map(res => res.json());
    }

}