import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OrdersPageComponent} from "./orders-page/orders-page.component";
import {SharedModule} from "../../shared/shared.module";
import {ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";


@NgModule({
  declarations: [
    OrdersPageComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [],
  exports:[
    OrdersPageComponent,

    ]
})
export class OrdersModule { }
