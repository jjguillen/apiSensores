package com.jaroso.apiinflux.entities;

import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "ubic_latitud")
    private Double ubicLatitud;

    @Column(name = "ubic_longitud")
    private Double ubicLongitud;

    public Sensor() {
    }

    public Sensor(Long id, String tipo, String unidadMedida, Double ubicLatitud, Double ubicLongitud) {
        this.id = id;
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.ubicLatitud = ubicLatitud;
        this.ubicLongitud = ubicLongitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getUbicLatitud() {
        return ubicLatitud;
    }

    public void setUbicLatitud(Double ubicLatitud) {
        this.ubicLatitud = ubicLatitud;
    }

    public Double getUbicLongitud() {
        return ubicLongitud;
    }

    public void setUbicLongitud(Double ubicLongitud) {
        this.ubicLongitud = ubicLongitud;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", ubicLatitud=" + ubicLatitud +
                ", ubicLongitud=" + ubicLongitud +
                '}';
    }
}
