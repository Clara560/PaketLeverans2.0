import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environment";
import {catchError, map, Observable, throwError} from "rxjs";
import {OrderRequest, OrderResponse} from '../../models/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl = 'http://localhost:8081/api/order/new';

  constructor(private http: HttpClient) { }


  updateOrder (orderId: number, orderRequest: OrderRequest): Observable<OrderResponse>{
    const url= `${environment.host}/api/order/update/${orderId}`;
    return this.http.put <OrderResponse> (url, orderRequest)
      .pipe(
        catchError ((err)=>{
          console.error('Error updating order', err);
          return throwError(()=> new Error(err.message));
        })
      );
  }



  createOrder (orderRequest: OrderRequest): Observable<OrderResponse> {
    return this.http.post<OrderResponse> (this.apiUrl,orderRequest)
      .pipe(
        catchError((err) => {
          console.error('Error creating order', err);
          return throwError(() => new Error(err.error.message));
    })
      );
  }



  getUserOrders(): Observable<Array<any>> {
    return this.http.get(`${environment.host}/api/order/user`)
      .pipe(
        map((response: any) => response),
        catchError((err) => {
          return throwError(err.error);
        })
      )
  }

  getOrderById(orderId: number): Observable<any> {
    return this.http.get(`${environment.host}/api/order/${orderId}`)
      .pipe(
        map((response: any) => response?.orders?.find(()=>true)),
        catchError((err) => {
          return throwError(err.error);
        })
      )
  }
}
