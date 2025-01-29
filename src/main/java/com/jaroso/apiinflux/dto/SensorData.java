package com.jaroso.apiinflux.dto;

import lombok.Data;


public class SensorData {
    private Long sensorId;
    private double value;

    public SensorData() {}

    public SensorData(Long sensorId, double value) {
        this.sensorId = sensorId;
        this.value = value;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
