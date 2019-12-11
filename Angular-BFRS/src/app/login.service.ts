import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Login } from './login';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) { }

  public addLogin(login: Login) {
    const body = JSON.stringify(login);
    return this.http.post('http://localhost:8080/BFRS/login',
      body, {headers: this.headers, withCredentials: true}).pipe(
        map(resp => resp as Login));
  }
}
