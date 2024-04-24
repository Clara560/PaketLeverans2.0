package com.app.data.entities;

import jakarta.persistence.*;

@Entity
public class address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @Column (name = "street")
    private String street;
    @Column (name = "city")
    private String city;
    @Column (name = "municipality")
    private String municipality;
    @Column (name = "zip")
    private String zip;
    @Column (name = "country")
    private String country;



}
