package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.backend.turno.backend_digiturno.models.entities.Entidad;
import com.unir.backend.turno.backend_digiturno.repositories.EntidadRepository;

@Service
public class EntidadServiceImpl implements EntidadService{

    private final EntidadRepository repository;

    public EntidadServiceImpl(EntidadRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entidad> finAll() {
        return (List<Entidad>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entidad> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Entidad save(Entidad entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional
    public Optional<Entidad> update(Entidad entidad, Long id) {
        Optional<Entidad> o = this.findById(id);
        if(o.isPresent()) {
            Entidad entidadDb = o.get();
            entidadDb.setNombre(entidad.getNombre());
            entidadDb.setDescripcion(entidad.getDescripcion());
            entidadDb.setTelefono(entidad.getTelefono());
            entidadDb.setCorreo(entidad.getCorreo());
            entidadDb.setDireccion(entidad.getDireccion());
            entidadDb.setEstado(entidad.getEstado());
            entidadDb.setFechcrea(entidad.getFechcrea());
            return Optional.of(repository.save(entidadDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }

}
