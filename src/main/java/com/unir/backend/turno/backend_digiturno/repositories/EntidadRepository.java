package com.unir.backend.turno.backend_digiturno.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unir.backend.turno.backend_digiturno.models.entities.Entidad;

public interface EntidadRepository extends CrudRepository<Entidad, Long>{
    Optional<Entidad> findByIdUsuario(Long idUsuario);
    Optional<Entidad> findByCorreo(String correo);
}
