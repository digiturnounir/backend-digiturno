package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import com.unir.backend.turno.backend_digiturno.models.entities.User;

public interface UserService {

    List<User> finAll();
    
    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> update(User user, Long id);

    void remove(Long id);

    Optional<User> findByCorreo(String correo);

}
