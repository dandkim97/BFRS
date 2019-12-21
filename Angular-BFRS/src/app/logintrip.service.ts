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
  public addLogintrip(loginTrip: Logintrip) {
    const body = JSON.stringify(loginTrip);
    return this.http.post('http://localhost:8080/BFRS/logintrips/', body, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Logintrip)
    );
  }
  public getLogintrip(id: number): Observable<Logintrip> {
    return this.http.get('http://localhost:8080/BFRS/logintrips/' + id, { withCredentials: true }).pipe(
      map(resp => resp as Logintrip )
    );
  }
  public cancelLoginTrip(loginTrip: Logintrip): Observable<Logintrip> {
    return this.http.delete('http://localhost:8080/BFRS/logintrips/' + loginTrip.tripId + '/' + loginTrip.userId,
    { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Logintrip)
    );
  }
}

