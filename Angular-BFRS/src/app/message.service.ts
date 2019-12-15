import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from './message';
import { map } from 'rxjs/operators';
import { Login } from './login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl = this.url.getUrl() + '/message';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private url: UrlService, private http: HttpClient) { }

  addMessage(message: Message) {
    const body = JSON.stringify(message);
    console.log(body);
    return this.http.post(this.appUrl, body,
      {headers: this.headers, withCredentials: true}).pipe(
        map(resp => resp as Message)
      );
  }

  getMessagesCustomer(user: Login): Observable<Message[]> {
    console.log('Is Customer');
    console.log(user.id);
    const url = this.appUrl + '/' + user.id;
    console.log(url);
    return this.http.get(url, {withCredentials: true}).pipe(
      map( resp => resp as Message[] )
      );
  }
}
