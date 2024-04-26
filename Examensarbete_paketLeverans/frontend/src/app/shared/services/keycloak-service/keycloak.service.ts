import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable, tap, throwError} from "rxjs";
import {environment} from "../../../../environment";

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {

  constructor(private http: HttpClient) {
  }

  public login(loginRequest: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });

    const body = new URLSearchParams();
    body.set('client_id', 'DeliverySystem');
    body.set('username', loginRequest.username);
    body.set('password', loginRequest.password);
    body.set('grant_type', 'password');

    return this.http.post(`${environment.keycloak.host}/realms/${environment.keycloak.realm}/protocol/openid-connect/token`, body, {headers})
      .pipe(
        map(response => (response)),
        tap((session: any) => {
          localStorage.setItem('access-token', JSON.stringify({
            access_token: session.access_token,
          }))
      }), catchError((err) => {
        return throwError(err.error);
      }))
  }
}
