import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, of, throwError} from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {Router} from "@angular/router";


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router: Router) {
  }

  public intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return of(JSON.parse(localStorage.getItem('access-token') ?? ""))
      .pipe(
        switchMap((auth) => {
          const token = auth ? auth.access_token : null;
          request = request.clone({
            setHeaders: {
              Authorization: token
            }
          });
          return next.handle(request);
        }),
        catchError((err) => {
          if (err.status === 401 || err.status === 403) {
            localStorage.setItem('access-token', "");
            this.router.navigate(['/login']);
          }
          return throwError(err);
        }));
  }
}
