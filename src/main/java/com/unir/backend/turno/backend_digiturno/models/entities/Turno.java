package com.unir.backend.turno.backend_digiturno.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer negocio_id;
    private Integer cliente_id;
    private LocalDate fecha;
    private LocalTime  hora;
    private String estado;
    private LocalDate creado_en;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNegocio_id() {
        return negocio_id;
    }
    public void setNegocio_id(Integer negocio_id) {
        this.negocio_id = negocio_id;
    }
    public Integer getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getCreado_en() {
        return creado_en;
    }
    public void setCreado_en(LocalDate creado_en) {
        this.creado_en = creado_en;
    }

    

}
