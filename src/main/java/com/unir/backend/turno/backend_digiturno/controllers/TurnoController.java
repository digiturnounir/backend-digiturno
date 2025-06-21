package com.unir.backend.turno.backend_digiturno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.backend.turno.backend_digiturno.Services.TurnoService;
import com.unir.backend.turno.backend_digiturno.models.entities.Turno;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @GetMapping
    public List<Turno> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Optional<Turno> turnoOptional = service.findById(id);

        if(turnoOptional.isPresent()){
            return ResponseEntity.ok(turnoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Turno turno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(turno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Turno turno, @PathVariable Long id){
        Optional<Turno> o = service.update(turno, id);
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        Optional<Turno> o = service.findById(id);

        if(o.isPresent()){
            service.remove(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
