import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";
import {KeycloakService} from "./services/keycloak-service/keycloak.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {OrderService} from "./services/order-service/order.service";
import {AuthInterceptor} from "./interceptors/auth.interceptor";

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    HttpClientModule,
    HeaderComponent,
    FooterComponent,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    KeycloakService,
    OrderService
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ]
})
export class SharedModule { }
