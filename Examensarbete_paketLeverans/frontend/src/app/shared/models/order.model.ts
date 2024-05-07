
import {User} from "./user.model";
import {Parcel} from "./parcel.model";


export interface OrderRequest {


  parcelWeight: number;
  parcelLength: number;
  parcelHeight: number;
  parcelWidth: number;

  dispatchAddress: string;

  deliveryAddress: string;

  orderDescription: string;

  orderStatus: string;

  orderComments: string;

  deliveryDate: Date;


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

  orderDateCreated: Date;

  deliveryDate: Date;

}

export interface OrderResponse {

  orders: Order [];

}








