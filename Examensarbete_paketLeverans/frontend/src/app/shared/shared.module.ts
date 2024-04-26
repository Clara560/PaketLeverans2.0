import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";
import {KeycloakService} from "./services/keycloak-service/keycloak.service";
import {HttpClientModule} from "@angular/common/http";
import {OrderService} from "./services/order-service/order.service";

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,lientM
    HttpCodule,
    HeaderComponent,
    FooterComponent,
  ],
  providers: [
    KeycloakService,
    OrderService
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ]
})
export class SharedModule { }
