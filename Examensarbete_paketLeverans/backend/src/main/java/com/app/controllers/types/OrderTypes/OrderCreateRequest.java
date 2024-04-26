package com.app.controllers.types.OrderTypes;

import com.app.data.entities.Parcel;
import com.app.data.entities.User;

import java.time.LocalDateTime;

public class OrderCreateRequest {

    private long orderId;

    private User user;

    private Parcel parcel;

    private String dispatchAddress;

    private String deliveryAddress;

    private String orderDescription;

    private LocalDateTime orderDateCreated;

    private LocalDateTime deliveryDate;

    private String orderStatus;

    private String orderComments;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public void setOrderDateCreated(LocalDateTime orderDateCreated) {
        this.orderDateCreated = orderDateCreated;
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
