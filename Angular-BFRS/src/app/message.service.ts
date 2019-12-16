import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Message } from './message';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl = this.url.getUrl() + '/message';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(
    private http: HttpClient,
    private url: UrlService
  ) { }

  getAdminMsgs(): Observable<Message[]> {
    return this.http.get(this.appUrl + '/admin', { withCredentials: true }).pipe(
      map(resp => resp as Message[] ));
  }

  updateMessage(message: Message): Observable<Message> {
    message.status = 'resolved';
    const body = JSON.stringify(message);
    console.log(body);
    return this.http.put(this.appUrl + '/' + message.id, body,
      { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Message ));
  }

  getMessage(id: number): Observable<Message> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp => resp as Message)
    );
  }

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
