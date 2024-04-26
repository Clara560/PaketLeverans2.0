import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../../shared/services/order-service/order.service";

@Component({
  selector: 'app-orders-page',
  standalone: false,
  templateUrl: './orders-page.component.html',
  styleUrl: './orders-page.component.scss'
})
export class OrdersPageComponent implements OnInit {

  private _orderService: OrderService;
  public orders: any;

  constructor(orderService: OrderService) {
    this._orderService = orderService;
  }

  ngOnInit(): void {
    this._orderService.getUserOrders().subscribe({
      next: ((res: any) => {
        this.orders = res;
      }),
      error: (error: Error) => {
        console.log(error)
      }
    });
  }
}
