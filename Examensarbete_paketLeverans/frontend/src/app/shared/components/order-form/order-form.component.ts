import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {OrderService} from "../../services/order-service/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-order-form',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './order-form.component.html',
  styleUrl: './order-form.component.scss'
})
export class OrderFormComponent implements OnInit{
  @Output() orderFormEvent: EventEmitter<any> = new EventEmitter<any>();
  @Input() public orderDetails: any;
  public orderForm: FormGroup;

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
      parcelWidth: new FormControl(null, [Validators.required]),
      deliveryDate: new FormControl(null, [Validators.required]),
    })
  }

  ngOnInit(): void {
    console.log(this.orderDetails)
    if (this.orderDetails)
      this.orderForm = new FormGroup({
        orderComments: new FormControl(this.orderDetails.orderComments, [Validators.required]),
        orderStatus: new FormControl(this.orderDetails.orderStatus, [Validators.required]),
        orderDescription: new FormControl(this.orderDetails.orderDescription, [Validators.required]),
        deliveryAddress: new FormControl(this.orderDetails.deliveryAddress, [Validators.required]),
        dispatchAddress: new FormControl(this.orderDetails.dispatchAddress, [Validators.required]),
        parcelWeight: new FormControl(this.orderDetails.parcel.parcelWeight, [Validators.required]),
        parcelLength: new FormControl(this.orderDetails.parcel.parcelLength, [Validators.required]),
        parcelHeight: new FormControl(this.orderDetails.parcel.parcelHeight, [Validators.required]),
        parcelWidth: new FormControl(this.orderDetails.parcel.parcelWidth, [Validators.required]),
        deliveryDate: new FormControl(this.orderDetails.deliveryDate, [Validators.required]),
      })

    }


  onSubmit() {
    if (this.orderForm?.valid) {
      this.orderFormEvent.emit(this.orderForm);
    }
  }

}
