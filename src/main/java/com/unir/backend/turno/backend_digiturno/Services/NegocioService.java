package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import com.unir.backend.turno.backend_digiturno.models.entities.Negocio;

public interface NegocioService {

    List<Negocio> finAll();

    Optional<Negocio> findById(Long id);

    Negocio save(Negocio negocio);

    Optional<Negocio> update(Negocio negocio, Long id);

    void remove(Long id);

}
