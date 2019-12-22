import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Review } from './review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private appUrl = this.url.getUrl() + '/review';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private url: UrlService, private http: HttpClient) { }

  addReview(review: Review) {
    console.log('adding new review');
    const body = JSON.stringify(review);
    console.log(body);
    return this.http.post(this.appUrl, body,
      {headers: this.headers, withCredentials: true}).pipe(
        map(resp => resp as Review)
      );
  }

  getReview(uid: number, model: string): Observable<Review> {
    console.log('trying to get review');
    const newUrl = this.appUrl + '/' + uid + '/' + model;
    console.log(newUrl);
    return this.http.get(newUrl, {withCredentials: true}).pipe(
      map(resp => resp as Review)
    );
  }

}
