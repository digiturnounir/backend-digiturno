package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import com.unir.backend.turno.backend_digiturno.models.entities.Entidad;

public interface EntidadService {

    List<Entidad> finAll();

    Optional<Entidad> findById(Long id);

    Entidad save(Entidad entidad);

    Optional<Entidad> update(Entidad entidad, Long id);

    void remove(Long id);

}
