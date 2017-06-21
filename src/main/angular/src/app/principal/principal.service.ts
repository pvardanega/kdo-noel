import { Injectable }                                 from "@angular/core";
import { Observable }                                 from "rxjs";
import { Response, Http, Headers, RequestOptions }    from "@angular/http";

import { environment }                                from '../../environments/environment';
 
@Injectable()
export class PrincipalService {
 
    constructor(private http: Http) { }
 
    me(): Observable<Response> {
        let headers = new Headers({'Content-Type': 'application/json;charset=utf-8'});
        return this.http.get(environment.apiUrl + "/me", JSON.stringify({headers: headers}));
    }
}