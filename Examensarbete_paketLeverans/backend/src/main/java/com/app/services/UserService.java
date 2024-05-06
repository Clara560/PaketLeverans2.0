package com.app.services;

import com.app.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.data.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public void updateUser(){

    }



}
