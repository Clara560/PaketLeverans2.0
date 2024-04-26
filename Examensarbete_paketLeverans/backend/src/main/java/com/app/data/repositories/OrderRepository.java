package com.app.data.repositories;

import com.app.data.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    List<Order> findAll();

    List<Order> findByUserId(Long userId);
}
