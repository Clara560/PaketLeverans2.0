package com.app.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order")
public class order {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @JoinColumn (name = "userID")
    private user user;

    @JoinColumn (name = "parcelId")
    private parcel parcel;

    @JoinColumn (name = "addressId")
    private address address;


    public order() {
    }

    public long getOrderId() {
        return orderId;
    }
}
