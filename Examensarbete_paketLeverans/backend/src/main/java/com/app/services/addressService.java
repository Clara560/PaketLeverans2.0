package com.app.services;

import com.app.data.repositories.addressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressService {

    @Autowired
    addressRepository addressRepository;

    public void createNewAddress(String address) {

    }

    public void updateAddress(String address) {

    }
    public void deleteAddress(String address) {

    }

    public void getAllAddresses() {

    }
    public void getAddressById(long address) {

    }

    public void getAddressByUserId(long userId) {

    }


}
