package com.app.controllers.types.ParcelTypes;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ParcelCreateRequest {



    private long id;

    private double parcelWeight;

    private double parcelLength;

    private double parcelHeight;

    private double parcelWidth;

    public ParcelCreateRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
