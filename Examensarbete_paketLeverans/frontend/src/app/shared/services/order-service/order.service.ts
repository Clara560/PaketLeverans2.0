import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environment";
import {catchError, map, Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  getUserOrders(): Observable<Array<any>> {
    return this.http.get(`${environment.host}/api/order/user`)
      .pipe(
        map((response: any) => response),
        catchError((err) => {
          return throwError(err.error);
        })
      )
  }
}
