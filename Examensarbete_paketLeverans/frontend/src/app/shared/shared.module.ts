import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";
import {KeycloakService} from "./services/keycloak-service/keycloak.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {OrderService} from "./services/order-service/order.service";
import {AuthInterceptor} from "./interceptors/auth.interceptor";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [

  ],
  imports: [
    RouterModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
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
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    HeaderComponent,
    FooterComponent
  ]
})
export class SharedModule { }
