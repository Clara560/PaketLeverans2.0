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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getDispatchAddress() {
        return dispatchAddress;
    }

    public void setDispatchAddress(String dispatchAddress) {
        this.dispatchAddress = dispatchAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public LocalDateTime getOrderDateCreated() {
        return orderDateCreated;
    }

    public void setOrderDateCreated() {
        this.orderDateCreated = LocalDateTime.now();
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }
}
