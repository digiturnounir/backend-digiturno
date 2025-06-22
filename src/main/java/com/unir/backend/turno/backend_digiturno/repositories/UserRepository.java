package com.unir.backend.turno.backend_digiturno.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unir.backend.turno.backend_digiturno.models.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
    Optional<User> findByCorreo(String correo);

}
