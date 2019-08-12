import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import {HttpClient, HttpHeaders, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PortfolioApiService {

  constructor( private http: HttpClient,) { }

   /**
     * Generic Get Method
     * Developer - Tarun
     * @param apiUrl - Api URL 
     */
    getApi(apiUrl: string) {
      return this.http.get(apiUrl, { headers: { 'content-type': 'application/json'} })
      .pipe(
        map((res) => res))
    }

  errorHandler(error: any,apiURl:string): void {
    console.log(error.message + apiURl + "--------------------------------")
  }

  /**
   * Generic Post Method
   * Developer - Tarun
   * @param apiUrl - Api URL 
   * @param body - Body of API
   */
  postApi(apiUrl: string,body: any) {
      return this.http.post(apiUrl, JSON.stringify(body), { headers: { 'content-type': 'application/json'} })
      .pipe(
        map((res) => res))
  }
}
