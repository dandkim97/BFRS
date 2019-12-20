import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Trip } from './trip';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TripService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  public getTrip(id: number): Observable<Trip> {
    return this.http.get('http://localhost:8080/BFRS/trips/' + id, { withCredentials: true }).pipe(
      map(resp => resp as Trip)
    );
  }

  public getTrips(): Observable<Trip[]> {
    return this.http.get('http://localhost:8080/BFRS/trips/', { withCredentials: true }).pipe(
      map(resp => resp as Trip[])
    );
  }

  public addTrip(trip: Trip) {
    const body = JSON.stringify(trip);
    return this.http.post('http://localhost:8080/BFRS/trips/add/', body, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Trip)
    );
  }


}
