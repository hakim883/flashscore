import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  constructor(private http: HttpClient) {}
  userURL: string = "http://localhost:8090/api/auth/";

  login(user) {
    return this.http.post<{accessToken:any}>(this.userURL + "login", user);
  }

  register(user): Observable<any> {
    return this.http.post(this.userURL + "signup", user);
  }
}
