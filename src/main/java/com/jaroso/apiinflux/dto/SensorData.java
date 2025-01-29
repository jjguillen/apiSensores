package com.jaroso.apiinflux.dto;

public class SensorData {
    private String location;
    private double value;

    public SensorData() {}

    public SensorData(String location, double value) {
        this.location = location;
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
