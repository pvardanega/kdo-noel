import { Injectable }                                 from "@angular/core";
import { Observable }                                 from "rxjs";
import { Response, Http, Headers, RequestOptions }    from "@angular/http";

import { environment }                                from '../../environments/environment';

@Injectable()
export class PrincipalService {

    private headers = { headers: new Headers({'Content-Type': 'application/json;charset=utf-8'})};

    constructor(private http: Http) { }

    me(): Observable<Response> {
        return this.http.get(environment.apiUrl + "/me", this.headers);
    }

    myList(): Observable<Response> {
        return this.http.get(environment.apiUrl + "/me/list", this.headers);
    }
}
