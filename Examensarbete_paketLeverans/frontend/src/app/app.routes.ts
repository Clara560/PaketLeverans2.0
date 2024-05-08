import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from "./pages/home/home-page/home-page.component";
import {OrdersPageComponent} from "./pages/orders/orders-page/orders-page.component";
import {LoginPageComponent} from "./pages/login/login-page/login-page.component";
import {OrderCreateComponent} from "./pages/orders/order-create/order-create.component";
import {NgModule} from "@angular/core";
import {OrderUpdateComponent} from "./pages/orders/order-update/order-update.component";

export const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'user/orders', component: OrdersPageComponent},
  {path: 'order/create', component: OrderCreateComponent},
  {path: 'order/update/:orderId', component: OrderUpdateComponent},
  {path: 'login', component: LoginPageComponent},
  {path: '**', redirectTo: ''}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
