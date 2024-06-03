import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurant } from './restaurant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
   private addUrl
   private searchUrl
  constructor(private http: HttpClient) { 
    this.addUrl="http://localhost:8080/add";
    this.searchUrl="http://localhost:8080/add"
  }

   addService(restaurant: Restaurant){
    return this.http.post(this.addUrl,restaurant,{responseType: 'text'});
   }
   getRestaurant(area: string): Observable<Restaurant[]> {
    const params = new HttpParams().set('area', area);
    return this.http.get<Restaurant[]>(this.searchUrl, { params });
  }
}
