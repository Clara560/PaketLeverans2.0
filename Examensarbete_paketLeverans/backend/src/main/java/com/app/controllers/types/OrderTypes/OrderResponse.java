package com.app.controllers.types.OrderTypes;

import com.app.data.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {

    private List<Order> orders = new ArrayList<Order>();


    public OrderResponse(List<Order> orders) {
        this.orders = orders;
    }

    public OrderResponse (Order order){
        this.orders.add(order);
    }

    public OrderResponse() {
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
