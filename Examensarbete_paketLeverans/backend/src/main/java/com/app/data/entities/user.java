package com.app.data.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "user")
public class user {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "firstName")
    private String firstName;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private Long phone;


    //Join to primary key?
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn (name = "addressId")
    private address address;

}
