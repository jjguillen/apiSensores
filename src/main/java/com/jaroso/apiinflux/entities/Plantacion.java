package com.jaroso.apiinflux.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Plantacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    //En el futuro podría ser una relación List<Coordenada>
    private String ubicacion;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    public Plantacion(String nombre, String ubicacion, String tipoProducto) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoProducto = tipoProducto;
    }

    public Plantacion() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Plantacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipoProducto='" + tipoProducto + '\'' +
                '}';
    }
}
