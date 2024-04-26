package com.app.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "tbl_parcel")
public class Parcel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "parcelWeight")
    private double parcelWeight;

    @Column (name = "parcelLength")
    private double parcelLength;

    @Column (name = "parcelHeight")
    private double parcelHeight;

    @Column (name = "parcelWidth")
    private double parcelWidth;

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
