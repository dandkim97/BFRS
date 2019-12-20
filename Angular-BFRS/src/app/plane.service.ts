import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plane } from './plane';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PlaneService {

  constructor(private http: HttpClient) { }

  public getPlane(model: string): Observable<Plane> {
    return this.http.get('http://localhost:8080/BFRS/plane/' + model, {withCredentials: true}).pipe(
      map(resp => resp as Plane)
    );
  }

}
