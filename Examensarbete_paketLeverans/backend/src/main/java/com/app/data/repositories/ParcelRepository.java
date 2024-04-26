package com.app.data.repositories;

import com.app.data.entities.Order;
import com.app.data.entities.Parcel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParcelRepository extends CrudRepository<Parcel, Long> {

    @Override
    List<Parcel> findAll();

    List<Parcel> findByUserId(Long userId);
}
