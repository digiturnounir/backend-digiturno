package com.unir.backend.turno.backend_digiturno.repositories;

import org.springframework.data.repository.CrudRepository;

import com.unir.backend.turno.backend_digiturno.models.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
