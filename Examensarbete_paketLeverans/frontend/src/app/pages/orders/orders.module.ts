import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OrdersPageComponent} from "./orders-page/orders-page.component";



@NgModule({
  declarations: [
    OrdersPageComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    OrdersPageComponent
    ]
})
export class OrdersModule { }
