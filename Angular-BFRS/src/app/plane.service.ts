import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Plane } from './plane';

@Injectable({
  providedIn: 'root'
})
export class PlaneService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public getPlanes(): Observable<Plane[]> {
    return this.http.get('http://localhost:8080/BFRS/plane/', { withCredentials: true }).pipe(
      map(resp => resp as Plane[])
    );
  }

  // public getPlane(id: number): Observable<Plane> {
  //   return this.http.get('http://localhost:8080/BFRS/plane/' + id, { withCredentials: true }).pipe(
  //     map(resp => resp as Plane)
  //   );
  // }

  public getPlane(model: string): Observable<Plane> {
    return this.http.get('http://localhost:8080/BFRS/plane/' + model, {withCredentials: true}).pipe(
      map(resp => resp as Plane)
    );
  }

}
