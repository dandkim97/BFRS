import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Message } from './message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl = this.urlSource.getUrl() + '/message';
  constructor(
    private http: HttpClient,
    private urlSource: UrlService
  ) { }

  getAdminMsgs(): Observable<Message[]> {
    return this.http.get(this.appUrl + '/admin', { withCredentials: true }).pipe(
      map(resp => resp as Message[] ));
  }
}
