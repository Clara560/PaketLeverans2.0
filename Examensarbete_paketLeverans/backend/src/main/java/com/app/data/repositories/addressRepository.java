package com.app.data.repositories;

import com.app.data.entities.address;
import org.springframework.data.repository.CrudRepository;

public interface addressRepository extends CrudRepository<address, Integer> {
}
