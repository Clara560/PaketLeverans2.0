package com.app.controllers.types.UserTypes;

import com.app.data.entities.Parcel;
import com.app.data.entities.User;
import org.keycloak.jose.jwk.JWK;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    private List<User> users = new ArrayList<User>();


    public UserResponse(List<User> users) {
        this.users = users;
    }

    public UserResponse (User user){
        this.users.add(user);
    }

    public UserResponse () {
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
