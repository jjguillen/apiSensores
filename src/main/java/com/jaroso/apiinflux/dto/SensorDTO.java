package com.jaroso.apiinflux.dto;

import jakarta.persistence.Column;

public class SensorDTO {

    private String tipo;
    private String unidadMedida;
    private Double ubicLatitud;
    private Double ubicLongitud;
    private Long plantacionId;

    public SensorDTO() {
    }

    // Getters y Setters

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

    public Long getPlantacionId() {
        return plantacionId;
    }

    public void setPlantacionId(Long plantacionId) {
        this.plantacionId = plantacionId;
    }
}
