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
    return of(JSON.parse(localStorage.getItem('access-token') ?? 'null'))
      .pipe(
        switchMap((auth) => {
          const token = auth ? auth.access_token : null;
          if (token)
            request = request.clone({
              setHeaders: {
                Authorization: `Bearer ${token}`
              }
            });
          return next.handle(request);
        }),
        catchError((err) => {
          if (err.status === 401 || err.status === 403) {
            this.router.navigate(['/login']);
          }
          return throwError(err);
        }));
  }
}
