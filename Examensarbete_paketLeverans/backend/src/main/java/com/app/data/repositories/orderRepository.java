package com.app.data.repositories;

import com.app.data.entities.order;
import org.springframework.data.repository.CrudRepository;

public interface orderRepository extends CrudRepository<order, Integer> {
}
