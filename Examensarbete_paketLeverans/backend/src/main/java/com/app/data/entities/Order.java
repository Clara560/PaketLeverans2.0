package com.app.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn (name = "parcelId")
    private Parcel parcel;

    @Column (name = "dispatchAddress")
    private String dispatchAddress;

    @Column (name = "deliveryAddress")
    private String deliveryAddress;

    @Column (name = "orderDescription")
    private String orderDescription;

    @Column (name = "orderDateCreated")
    private LocalDateTime orderDateCreated;

    @Column (name = "deliveryDate")
    private LocalDateTime deliveryDate;

    @Column (name = "orderStatus")
    private String orderStatus;

    @Column (name = "orderComments")
    private String orderComments;

}
