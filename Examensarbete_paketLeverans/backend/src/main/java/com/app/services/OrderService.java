package com.app.services;

import com.app.data.entities.Order;
import com.app.data.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    public void createNewOrder() {

    }

    public void deleteOrder() {

    }

    public void updateOrder() {

    }

    public Order getAllOrders (){
        return null;
    }

    public Order getOrderById(int id) {

        return null;
    }



}
