import { Component } from '@angular/core';
import {OrderFormComponent} from "../../../shared/components/order-form/order-form.component";
import {OrderRequest} from "../../../shared/models/order.model";
import {OrderService} from "../../../shared/services/order-service/order.service";
import {Router} from "@angular/router";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-order-update',
  standalone: true,
  imports: [
    OrderFormComponent,
    NgIf
  ],
  templateUrl: './order-update.component.html',
  styleUrl: './order-update.component.scss'
})
export class OrderUpdateComponent {
  orderDetails: any;

  constructor(
    private orderService: OrderService,
    private router: Router
  ) {
    this.getOrder();
  }

   getOrder (){
    //the get order by id has to have its own button.
    this.orderService.getOrderById(2).subscribe({
      next: ((response) => {
        this.orderDetails = response;
      }),
      error: (error) => {
        console.error('Error getting order', error);
      }
    });
  }

  orderFormUpdate(data: any) {
    let orderValues = data.value;
    let request: OrderRequest= {
      orderComments: orderValues.orderComments,
      orderStatus: orderValues.orderStatus,
      orderDescription: orderValues.orderDescription,
      deliveryAddress: orderValues.deliveryAddress,
      dispatchAddress: orderValues.dispatchAddress,
      parcelWeight: orderValues.parcelWeight,
      parcelLength: orderValues.parcelLength,
      parcelHeight: orderValues.parcelHeight,
      parcelWidth: orderValues.parcelWidth,
      deliveryDate: new Date(orderValues.deliveryDate)
    }

    this.orderService.updateOrder(2,request).subscribe({
      next: ((response) => {
        console.log('Order updated', response);
        alert('Order successfully updated');
        this.router.navigate (['/user/orders']);
      }),
      error: (error) => {
        console.error('Error updating order', error);
      }
    });
  }
}
