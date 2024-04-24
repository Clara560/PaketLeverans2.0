package com.app.data.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "parcel")
public class parcel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parcelId;

    @Column (name = "parcelWeight")
    private double parcelWeight;

    @Column (name = "parcelLength")
    private double parcelLength;

    @Column (name = "parcelHeight")
    private double parcelHeight;

    @Column (name = "parcelWidth")
    private double parcelWidth;

    @Column (name = "parcelDescription")
    private String parcelDescription;

    @Column (name = "parcelDateCreated")
    private String parcelDateCreated;

    @Column (name = "parcelStatus")
    private String parcelStatus;

    @Column (name = "parcelComments")
    private String parcelComments;



}
