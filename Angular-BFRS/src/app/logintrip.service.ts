import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Logintrip } from './logintrip';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LogintripService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  public getAllHistoryTrips(): Observable<Logintrip[]> {
    return this.http.get('http://localhost:8080/BFRS/logintrips/', { withCredentials: true }).pipe(
      map(resp => resp as Logintrip[])
    );
  }
}

