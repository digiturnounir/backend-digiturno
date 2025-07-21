package com.unir.backend.turno.backend_digiturno.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.backend.turno.backend_digiturno.models.entities.Negocio;
import com.unir.backend.turno.backend_digiturno.repositories.NegocioRepository;
import com.unir.backend.turno.backend_digiturno.repositories.UserRepository;

@Service
public class NegocioServiceImpl implements NegocioService {

    private final NegocioRepository repository;
    private final UserRepository userRepository;

    public NegocioServiceImpl(NegocioRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Negocio> finAll() {
        return (List<Negocio>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Negocio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Negocio save(Negocio negocio) {
        if (negocio.getIdUsuario() == null || !userRepository.existsById(negocio.getIdUsuario())) {
            throw new IllegalArgumentException("El usuario asociado no existe.");
        }

        return repository.save(negocio);
    }

    @Override
    @Transactional
    public Optional<Negocio> update(Negocio negocio, Long id) {
        Optional<Negocio> o = this.findById(id);
        if (o.isPresent()) {
            if (negocio.getIdUsuario() == null || !userRepository.existsById(negocio.getIdUsuario())) {
                throw new IllegalArgumentException("El usuario asociado no existe.");
            }

            Negocio negocioDb = o.get();
            negocioDb.setNombre(negocio.getNombre());
            negocioDb.setDireccion(negocio.getDireccion());
            negocioDb.setIdCategoria(negocio.getIdCategoria());
            negocioDb.setFechcrea(negocio.getFechcrea());
            negocioDb.setIdUsuario(negocio.getIdUsuario());

            return Optional.of(repository.save(negocioDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
