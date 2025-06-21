package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.backend.turno.backend_digiturno.models.entities.User;
import com.unir.backend.turno.backend_digiturno.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> finAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<User> update(User user, Long id) {
        Optional<User> o = this.findById(id);
        if(o.isPresent()){
            User userDb = o.orElseThrow();
            userDb.setNombre(user.getNombre());
            userDb.setCorreo(user.getCorreo());
            userDb.setContrasena(user.getContrasena());
            userDb.setRol(user.getRol());
            userDb.setCreado_en(user.getCreado_en());
            return Optional.of(this.save(userDb));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

}
