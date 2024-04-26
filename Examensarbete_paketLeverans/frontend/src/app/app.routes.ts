import { Routes } from '@angular/router';
import {HomePageComponent} from "./pages/home/home-page/home-page.component";
import {OrdersPageComponent} from "./pages/orders/orders-page/orders-page.component";
import {LoginPageComponent} from "./pages/login/login-page/login-page.component";

export const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'user/orders', component: OrdersPageComponent},
  {path: 'login', component: LoginPageComponent}
];
