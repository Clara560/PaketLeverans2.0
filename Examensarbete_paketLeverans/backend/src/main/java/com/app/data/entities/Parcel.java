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
}
