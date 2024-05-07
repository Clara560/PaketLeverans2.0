package com.app.controllers.types.OrderTypes;

import com.app.data.entities.Parcel;
import com.app.data.entities.User;

import java.time.LocalDateTime;

public class OrderCreateRequest {


    private double parcelWeight;

    private double parcelLength;

    private double parcelHeight;

    private double parcelWidth;


    private String dispatchAddress;

    private String deliveryAddress;

    private String orderDescription;

    private LocalDateTime orderDateCreated;

    private LocalDateTime deliveryDate;

    private String orderStatus;

    private String orderComments;


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

    public double getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(double parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public double getParcelLength() {
        return parcelLength;
    }

    public void setParcelLength(double parcelLength) {
        this.parcelLength = parcelLength;
    }

    public double getParcelHeight() {
        return parcelHeight;
    }

    public void setParcelHeight(double parcelHeight) {
        this.parcelHeight = parcelHeight;
    }

    public double getParcelWidth() {
        return parcelWidth;
    }

    public void setParcelWidth(double parcelWidth) {
        this.parcelWidth = parcelWidth;
    }
}
