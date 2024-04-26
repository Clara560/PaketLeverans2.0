import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";
import {KeycloakService} from "./services/keycloak-service/keycloak.service";



@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    HeaderComponent,
    FooterComponent
  ],
  providers: [
    KeycloakService
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ]
})
export class SharedModule { }
