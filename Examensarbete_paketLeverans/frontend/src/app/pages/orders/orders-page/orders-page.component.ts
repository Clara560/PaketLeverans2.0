import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../../shared/services/order-service/order.service";
import {CommonModule} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-orders-page',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ],
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
        if (res && res.orders)
          this.orders = res.orders;
      }),
      error: (error: Error) => {
        console.log(error)
      }
    });
  }
}
