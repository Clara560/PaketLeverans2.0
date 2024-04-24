package com.app.data.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "tbl_user")
public class User {

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
}
