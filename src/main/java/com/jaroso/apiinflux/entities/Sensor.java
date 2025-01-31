package com.jaroso.apiinflux.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Sensor {

    public enum Tipo {
        TEMPERATURA,
        HUMEDAD,
        LUMINOSIDAD,
        VIENTO,
        LLUVIA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Tipo tipo;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "ubic_latitud")
    private Double ubicLatitud;

    @Column(name = "ubic_longitud")
    private Double ubicLongitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "plantacion_id", nullable = false)
    private Plantacion plantacion;

    public Sensor() {
    }

    public Sensor(Tipo tipo, String unidadMedida, Double ubicLatitud, Double ubicLongitud, Plantacion plantacion) {
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.ubicLatitud = ubicLatitud;
        this.ubicLongitud = ubicLongitud;
        this.plantacion = plantacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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

    public Plantacion getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantacion plantacion) {
        this.plantacion = plantacion;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", ubicLatitud=" + ubicLatitud +
                ", ubicLongitud=" + ubicLongitud +
                ", plantacion=" + plantacion.getId() +
                '}';
    }
}
