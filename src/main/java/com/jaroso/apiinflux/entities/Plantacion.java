package com.jaroso.apiinflux.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "plantacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sensor> sensores;

    public Plantacion() {
    }

    public Plantacion(Long id, String nombre, String ubicacion, String tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoProducto = tipoProducto;
    }

    public Plantacion(String nombre, String ubicacion, String tipoProducto) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoProducto = tipoProducto;
    }

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

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    @Override
    public String toString() {
        return "Plantacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", sensores=" + sensores +
                '}';
    }
}
