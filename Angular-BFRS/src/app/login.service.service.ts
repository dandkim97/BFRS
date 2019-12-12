import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import { Login } from './login';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class LoginService {
  private appUrl = this.url.getUrl() + '/login';
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
  private loginUser: Login;
  constructor(private url: UrlService, private http: HttpClient) { }

  login(username: string, password: string): Observable<Login> {
    if (username && password) {
      // we are attempting to log in
      const body = `user=${username}&pass=${password}`;
      console.log(body);
      return this.http.post(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Login = resp as Login;
          console.log("Logged In!");
          console.log(user);
          if (user) {
            this.loginUser = user;
          }
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
      return this.http.get(this.appUrl, {withCredentials: true}).pipe(
        map( resp => {
          const user: Login = resp as Login;
          console.log("Checking if logged in");
          if (user) {
            this.loginUser = user;
          }
          return user;
        })
      );
    }
  }
  logout(): Observable<object> {
    return this.http.delete(this.appUrl, {withCredentials: true}).pipe(
      map(success => {
        this.loginUser = null;
        return success;
      })
    );
  }
}
