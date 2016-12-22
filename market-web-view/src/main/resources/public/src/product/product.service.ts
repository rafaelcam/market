import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class ProductService {
    private url = 'http://ec2-54-187-197-124.us-west-2.compute.amazonaws.com:8081/';

    constructor(private http: Http) { }

    findAll(): Observable<any> {
        return this.http.get(this.url+"product/").map(res => res.json());
    }

}