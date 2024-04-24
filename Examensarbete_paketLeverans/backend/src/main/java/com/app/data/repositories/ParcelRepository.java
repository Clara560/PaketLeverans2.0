package com.app.data.repositories;

import com.app.data.entities.Parcel;
import org.springframework.data.repository.CrudRepository;

public interface ParcelRepository extends CrudRepository<Parcel, Long> {
}
