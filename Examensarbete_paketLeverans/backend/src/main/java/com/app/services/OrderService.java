package com.app.services;

import com.app.controllers.types.OrderTypes.OrderCreateRequest;
import com.app.controllers.types.OrderTypes.OrderResponse;
import com.app.controllers.types.OrderTypes.OrderUpdateRequest;
import com.app.data.entities.Order;
import com.app.data.entities.Parcel;
import com.app.data.entities.User;
import com.app.data.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    public ResponseEntity<OrderResponse> createNewOrder(OrderCreateRequest orderCreateRequest, User user) {
        Order order = new Order();

        order.setOrderComments(orderCreateRequest.getOrderComments());
        order.setOrderDateCreated();
        order.setOrderStatus("Requested");
        order.setOrderDescription(orderCreateRequest.getOrderDescription());
        order.setDeliveryAddress(orderCreateRequest.getDeliveryAddress());
        order.setDispatchAddress(orderCreateRequest.getDispatchAddress());
        order.setDeliveryDate(orderCreateRequest.getDeliveryDate());
        order.setUser(user);

        Parcel parcel = new Parcel();
        parcel.setParcelWidth(orderCreateRequest.getParcelWidth());
        parcel.setParcelWeight(orderCreateRequest.getParcelWeight());
        parcel.setParcelLength(orderCreateRequest.getParcelLength());
        parcel.setParcelHeight(orderCreateRequest.getParcelHeight());

        order.setParcel(parcel);

        return ResponseEntity.ok(new OrderResponse(orderRepository.save(order)));


    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    public ResponseEntity<OrderResponse> updateOrder(OrderUpdateRequest orderUpdateRequest, long id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty())
            return ResponseEntity.notFound().build();

        Order updatedOrder = order.get();
        if (order.isPresent()) {
            updatedOrder.setOrderComments(orderUpdateRequest.getOrderComments());
            updatedOrder.setOrderDescription(orderUpdateRequest.getOrderDescription());
            updatedOrder.setDeliveryAddress(orderUpdateRequest.getDeliveryAddress());
            updatedOrder.setDispatchAddress(orderUpdateRequest.getDispatchAddress());
            updatedOrder.setDeliveryDate(orderUpdateRequest.getDeliveryDate());

            Parcel parcel = updatedOrder.getParcel();
            parcel.setParcelHeight(orderUpdateRequest.getParcelHeight());
            parcel.setParcelWidth(orderUpdateRequest.getParcelWidth());
            parcel.setParcelWeight(orderUpdateRequest.getParcelWeight());
            parcel.setParcelLength(orderUpdateRequest.getParcelLength());


            orderRepository.save(updatedOrder);

        }

        return ResponseEntity.ok(new OrderResponse(orderRepository.save(updatedOrder)));


    }

    public ResponseEntity<OrderResponse> getAllOrders() {
        return ResponseEntity.ok(new OrderResponse(orderRepository.findAll()));
    }

    public ResponseEntity<OrderResponse> getOrderById(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new OrderResponse(optionalOrder.get()));
    }


    public ResponseEntity<OrderResponse> getOrderByUserId(long id) {
        return ResponseEntity.ok(new OrderResponse(orderRepository.findByUserId(id)));
    }
}
