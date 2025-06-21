package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import com.unir.backend.turno.backend_digiturno.models.entities.Turno;

public interface TurnoService {

    List<Turno> findAll();
    
    Optional<Turno> findById(Long id);

    Turno save(Turno turno);

    Optional<Turno> update(Turno turno, Long id);

    void remove(Long id);

}
