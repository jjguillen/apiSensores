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

    private String pais;

    private String provincia;

    private String ciudad;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @OneToMany(mappedBy = "plantacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sensor> sensores;

    public Plantacion() {
    }

    public Plantacion(Long id, String nombre, String ubicacion, String pais, String provincia, String ciudad, String tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.tipoProducto = tipoProducto;
    }

    public Plantacion(String nombre, String ubicacion, String pais, String provincia, String ciudad, String tipoProducto) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", sensores=" + sensores +
                '}';
    }
}
