package com.unir.backend.turno.backend_digiturno.models.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "negocios")
public class Negocio {

    @Id
    @Generated()
    @Column(name = "id_negocio", updatable = false, insertable = false)
    private Long idNegocio;

    @Column(name = "usuario_id", nullable = false)
    private Long idUsuario;

    @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "creado_en")
    private LocalDateTime fechcrea;

    public Long getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Long idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechcrea() {
        return fechcrea;
    }

    public void setFechcrea(LocalDateTime fechcrea) {
        this.fechcrea = fechcrea;
    }

    
}
