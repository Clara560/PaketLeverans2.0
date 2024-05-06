
import {User} from "./user.model";
import {Parcel} from "./parcel.model";

export type LocalDateTime = string;

export interface OrderCreateRequest {

  orderId: bigint;

  parcelWeight: number;
  parcelLength: number;
  parcelHeight: number;
  parcelWidth: number;

  dispatchAddress: string;

  deliveryAddress: string;

  orderDescription: string;

  orderStatus: string;

  orderComments: string;

  orderDateCreated: LocalDateTime;

  deliveryDate: LocalDateTime;


}

export interface Order {

  orderId: bigint;

  user: User;

  parcel: Parcel;

  dispatchAddress: string;

  deliveryAddress: string;

  orderDescription: string;

  orderStatus: string;

  orderComments: string;

  orderDateCreated: LocalDateTime;

  deliveryDate: LocalDateTime;

}

export interface OrderResponse {

  orders: Order [];

}








