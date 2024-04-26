import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OrdersPageComponent} from "./orders-page/orders-page.component";
import {SharedModule} from "../../shared/shared.module";



@NgModule({
  declarations: [
    OrdersPageComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports:[
    OrdersPageComponent
    ]
})
export class OrdersModule { }
