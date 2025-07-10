package com.unir.backend.turno.backend_digiturno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.backend.turno.backend_digiturno.Services.EntidadService;
import com.unir.backend.turno.backend_digiturno.models.entities.Entidad;
import com.unir.backend.turno.backend_digiturno.response.ApiResponse;

@RestController
@RequestMapping("/entidad")
public class EntidadController {

    @Autowired
    private EntidadService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Entidad>>> list() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Lista de entidades", 2000, service.finAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> show(@PathVariable Long id) {
        return service.findById(id)
                .<ResponseEntity<ApiResponse<?>>>map(entidad ->
                        ResponseEntity.ok(new ApiResponse<>(true, "Entidad encontrada", 2000, entidad)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Entidad no encontrada", 4040, null)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> create(@RequestBody Entidad entidad) {
        try {
            Entidad nuevo = service.save(entidad);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Entidad creada", 2010, nuevo));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, e.getMessage(), 4000, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody Entidad entidad, @PathVariable Long id) {
        return service.update(entidad, id)
                .<ResponseEntity<ApiResponse<?>>>map(e ->
                        ResponseEntity.ok(new ApiResponse<>(true, "Entidad actualizada", 2001, e)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Entidad no encontrada", 4041, null)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> remove(@PathVariable Long id) {
        Optional<Entidad> o = service.findById(id);
        if (o.isPresent()) {
            service.remove(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Entidad eliminada", 2002, null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "Entidad no encontrada", 4042, null));
    }

}
