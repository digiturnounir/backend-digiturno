package com.unir.backend.turno.backend_digiturno.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @Generated()
    @Column(name = "id_turno", updatable = false, insertable = false)
    private Long idTurno;

    private Integer negocio_id;
    private Integer cliente_id;
    private LocalDate fecha;
    private LocalTime  hora;
    private String estado_id;
    private LocalDate creado_en;

    public Long getIdTurno() {
        return idTurno;
    }
    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
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
    public String getEstado_id() {
        return estado_id;
    }
    public void setEstado_id(String estado_id) {
        this.estado_id = estado_id;
    }
    public LocalDate getCreado_en() {
        return creado_en;
    }
    public void setCreado_en(LocalDate creado_en) {
        this.creado_en = creado_en;
    }

    

}
