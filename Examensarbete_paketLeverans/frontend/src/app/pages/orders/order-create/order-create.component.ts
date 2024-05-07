import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {OrderService} from "../../../shared/services/order-service/order.service";
import {Router} from "@angular/router";
import {SharedModule} from "../../../shared/shared.module";
import {OrderRequest} from "../../../shared/models/order.model";
import {OrderFormComponent} from "../../../shared/components/order-form/order-form.component";


@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  standalone: true,
  imports: [
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    OrderFormComponent
  ],
  styleUrl: './order-create.component.scss'
})
export class OrderCreateComponent {
  constructor(
    private orderService: OrderService,
    private router: Router
  ) {
  }

  orderFormUpdate(data: any) {
      let orderValues = data.value;
      let request: OrderRequest = {
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
      this.orderService.createOrder(request).subscribe({
        next: ((response) => {
          console.log('Order created', response);
          alert('Order successfully created');
          this.router.navigate (['/user/orders']);
        }),
        error: (error) => {
          console.error('Error creating order', error);
        }
      });
  }
}
