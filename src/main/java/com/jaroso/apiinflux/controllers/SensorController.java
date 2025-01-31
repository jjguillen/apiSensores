package com.jaroso.apiinflux.controllers;


import com.jaroso.apiinflux.dto.SensorDTO;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.services.SensorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public Sensor saveSensor(@RequestBody SensorDTO sensorDTO) {
        return sensorService.saveSensor(sensorDTO);
    }
}
