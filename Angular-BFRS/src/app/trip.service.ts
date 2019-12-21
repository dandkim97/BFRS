import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Trip } from './trip';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class TripService {
  private appUrl = this.url.getUrl() + '/trips';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(
    private http: HttpClient,
    private url: UrlService
  ) { }

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
    console.log(trip.departure);
    trip.departure = trip.departure.replace('T', ' ').concat(':00');
    console.log(trip.departure);
    console.log(trip.arrival);
    trip.arrival = trip.arrival.replace('T', ' ').concat(':00');
    console.log(trip.arrival);
    const body = JSON.stringify(trip);
    return this.http.post('http://localhost:8080/BFRS/trips/', body, { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Trip)
    );
  }

  public updateTrip(trip: Trip): Observable<Trip> {
    const body = JSON.stringify(trip);
    console.log(body);
    return this.http.put(this.appUrl, body,
      { headers: this.headers, withCredentials: true }).pipe(
      map(resp => resp as Trip)) ;
  }

}
