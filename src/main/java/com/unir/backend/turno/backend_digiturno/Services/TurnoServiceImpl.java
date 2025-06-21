package com.unir.backend.turno.backend_digiturno.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.backend.turno.backend_digiturno.models.entities.Turno;
import com.unir.backend.turno.backend_digiturno.repositories.TurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService{

    private TurnoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Turno> findAll() {
        return (List<Turno>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Turno> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Turno> update(Turno turno, Long id) {
        Optional<Turno> o = this.findById(id);
        if(o.isPresent()){
            Turno turnoDb = o.orElseThrow();
            turnoDb.setCliente_id(turno.getCliente_id());
            turnoDb.setFecha(turno.getFecha());
            turnoDb.setHora(turno.getHora());
            turnoDb.setEstado(turno.getEstado());
            turnoDb.setCreado_en(turno.getCreado_en());
            return Optional.of(this.save(turnoDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Turno save(Turno turno) {
        return repository.save(turno);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }

}
