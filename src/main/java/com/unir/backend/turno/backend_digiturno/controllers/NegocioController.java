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

import com.unir.backend.turno.backend_digiturno.Services.NegocioService;
import com.unir.backend.turno.backend_digiturno.models.entities.Negocio;
import com.unir.backend.turno.backend_digiturno.response.ApiResponse;

@RestController
@RequestMapping("/negocio")
public class NegocioController {

    @Autowired
    private NegocioService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Negocio>>> list() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Lista de negocios", 2000, service.finAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> show(@PathVariable Long id) {
        return service.findById(id)
                .<ResponseEntity<ApiResponse<?>>>map(negocio ->
                        ResponseEntity.ok(new ApiResponse<>(true, "Negocio encontrado", 2000, negocio)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Negocio no encontrada", 4040, null)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> create(@RequestBody Negocio negocio) {
        try {
            Negocio nuevo = service.save(negocio);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Negocio creado", 2010, nuevo));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, e.getMessage(), 4000, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody Negocio negocio, @PathVariable Long id) {
        return service.update(negocio, id)
                .<ResponseEntity<ApiResponse<?>>>map(e ->
                        ResponseEntity.ok(new ApiResponse<>(true, "Negocio actualizado", 2001, e)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Negocio no encontrado", 4041, null)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> remove(@PathVariable Long id) {
        Optional<Negocio> o = service.findById(id);
        if (o.isPresent()) {
            service.remove(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Negocio eliminado", 2002, null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "Negocio no encontrado", 4042, null));
    }

}
