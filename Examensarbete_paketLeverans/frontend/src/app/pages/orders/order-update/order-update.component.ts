import {Component} from '@angular/core';
import {OrderFormComponent} from "../../../shared/components/order-form/order-form.component";
import {OrderRequest} from "../../../shared/models/order.model";
import {OrderService} from "../../../shared/services/order-service/order.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-order-update',
  standalone: true,
  imports: [
    OrderFormComponent,
    NgIf,
    FormsModule
  ],
  templateUrl: './order-update.component.html',
  styleUrl: './order-update.component.scss'
})
export class OrderUpdateComponent {
  orderDetails: any;
  private orderId: any;

  constructor(
    private activeRoute: ActivatedRoute,
    private orderService: OrderService,
    private router: Router
  ) {
    this.activeRoute.paramMap
      .subscribe((params) => {

        const orderId: any = params.get('orderId');
        if(orderId)
          this.getOrder(orderId);
      })


  }

  getOrder(orderId: number) {
    this.orderService.getOrderById(orderId).subscribe({
      next: ((response) => {
        this.orderId = response.id;
        this.orderDetails = response;
      }),
      error: (error) => {
        console.error('Error getting order', error);
      }
    });
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

    this.orderService.updateOrder(this.orderId, request).subscribe({
      next: ((response) => {
        console.log('Order updated', response);
        alert('Order successfully updated');
        this.router.navigate(['/user/orders']);
      }),
      error: (error) => {
        console.error('Error updating order', error);
      }
    });
  }

}
