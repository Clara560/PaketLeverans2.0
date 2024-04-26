package com.app.controllers;

import com.app.controllers.types.OrderTypes.OrderCreateRequest;
import com.app.controllers.types.OrderTypes.OrderResponse;
import com.app.controllers.types.OrderTypes.OrderUpdateRequest;
import com.app.data.entities.User;
import com.app.services.OrderService;
import com.app.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/order")
public class OrderController extends UserAuthService {


    @Autowired
    OrderService orderService;

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("/new")
    public ResponseEntity<OrderResponse> newOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        return orderService.createNewOrder(orderCreateRequest);
    }

    @PutMapping("update")
    public ResponseEntity<OrderResponse> updateOrder(@RequestBody OrderUpdateRequest orderUpdateRequest) {
        return orderService.updateOrder(orderUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/all")
    public ResponseEntity<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") int id) {
        return orderService.getOrderById(id);

    }

    @GetMapping("/user")
    public ResponseEntity<OrderResponse> getOrdersByUser()
    {
        Optional<User> authenticatedUser = userAuthService.getAuthenticatedUser();

        if (authenticatedUser.isEmpty())
            return ResponseEntity.notFound().build();

        return orderService.getOrderByUserId(authenticatedUser.get().getId());
    }


}
