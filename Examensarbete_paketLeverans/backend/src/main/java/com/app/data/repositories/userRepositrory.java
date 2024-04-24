package com.app.data.repositories;

import com.app.data.entities.user;
import org.springframework.data.repository.CrudRepository;

public interface userRepositrory extends CrudRepository<user, Long> {
}
