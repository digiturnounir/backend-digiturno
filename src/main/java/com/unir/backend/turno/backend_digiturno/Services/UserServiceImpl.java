package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.backend.turno.backend_digiturno.models.entities.User;
import com.unir.backend.turno.backend_digiturno.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

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
        if (o.isPresent()) {
            User userDb = o.orElseThrow();
            userDb.setNombre(user.getNombre());
            userDb.setCorreo(user.getCorreo());
            userDb.setContrasena(passwordEncoder.encode(user.getContrasena()));
            userDb.setRol(user.getRol());
            userDb.setCreado_en(user.getCreado_en());
            return Optional.of(this.save(userDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        return repository.save(user);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Optional<User> findByCorreo(String correo) {
        return repository.findByCorreo(correo);
    }
}
