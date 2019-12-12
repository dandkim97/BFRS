import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Form } from './form';
import { UrlService } from 'src/app/url.service';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private appUrl = this.url.getUrl() + '/form';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private url: UrlService, private http: HttpClient) { }

  public getForms(): Observable<Form[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map(resp => resp as Form[])
    );
  }

  public getForm(id: number): Observable<Form> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(resp => resp as Form)
    );
  }

  public addForm(form: Form) {
    const body = JSON.stringify(form);
    const url = this.appUrl;
    return this.http.post(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Form)
    );
  }

  public updateForm(form: Form): Observable<Form> {
    const body = JSON.stringify(form);
    if (form.id) {
      const url = this.appUrl + '/' + form.id;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
          map(resp => resp as Form)
        );
    } else {
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
          map(resp => resp as Form)
        );
    }
  }
}
