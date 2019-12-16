import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Form } from './form';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  public getForms(): Observable<Form[]> {
    return this.http.get('http://localhost:8080/BFRS/form/', { withCredentials: true }).pipe(
      map(resp => resp as Form[])
    );
  }

  public getForm(id: number): Observable<Form> {
    return this.http.get('http://localhost:8080/BFRS/form/' + id, { withCredentials: true }).pipe(
      map(resp => resp as Form)
    );
  }

  public addForm(form: Form) {
    const body = JSON.stringify(form);
    return this.http.post('http://localhost:8080/BFRS/form/', body, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Form)
    );
  }

  public updateForm(form: Form): Observable<Form> {
    const url = 'http://localhost:8080/BFRS/form/' + form.id;
    const body = JSON.stringify(form);
    return this.http.put(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Form)
    );
  }
  public deleteRanger(form: Form): Observable<void> {
    const url = 'http://localhost:8080/BFRS/form/' + form.id;
    const body = JSON.stringify(form);
    return this.http.delete(url, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => null)
    );
  }
}
