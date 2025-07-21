package com.unir.backend.turno.backend_digiturno.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unir.backend.turno.backend_digiturno.models.entities.Negocio;

public interface NegocioRepository extends CrudRepository<Negocio, Long>{
    Optional<Negocio> findByIdUsuario(Long idUsuario);
}
