import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {OrderService} from "../../../shared/services/order-service/order.service";
import {Router} from "@angular/router";
import {SharedModule} from "../../../shared/shared.module";


@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  standalone: true,
  imports: [
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  styleUrl: './order-create.component.scss'
})
export class OrderCreateComponent {
  orderForm: FormGroup;

  constructor(
    private orderService: OrderService,
    private router: Router
  ) {
    this.orderForm = new FormGroup({
      orderComments: new FormControl(null, [Validators.required]),
      orderStatus: new FormControl(null, [Validators.required]),
      orderDescription: new FormControl(null, [Validators.required]),
      deliveryAddress: new FormControl(null, [Validators.required]),
      dispatchAddress: new FormControl(null, [Validators.required]),
      parcelWeight: new FormControl(null, [Validators.required]),
      parcelLength: new FormControl(null, [Validators.required]),
      parcelHeight: new FormControl(null, [Validators.required]),
      parcelWidth: new FormControl(null, [Validators.required])
    })
  }





  onSubmit (){
    if (this.orderForm.valid){
      this.orderService.createOrder(this.orderForm.value).subscribe({
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

}
