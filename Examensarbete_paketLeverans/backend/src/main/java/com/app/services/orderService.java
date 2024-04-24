package com.app.services;

import com.app.data.entities.order;
import com.app.data.repositories.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {


    @Autowired
    orderRepository orderRepository;

    public void createNewOrder() {

    }

    public void deleteOrder() {

    }

    public void updateOrder() {

    }

    public order getAllOrders (){
        return null;
    }

    public order getOrderById(int id) {

        return null;
    }



}
