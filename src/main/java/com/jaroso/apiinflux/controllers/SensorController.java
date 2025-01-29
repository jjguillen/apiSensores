package com.jaroso.apiinflux.controllers;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.dto.SensorData;
import com.jaroso.apiinflux.services.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class SensorController {

    private final SensorService sensorService;


    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public String writeData(@RequestBody SensorData data) {
        sensorService.saveData(data.getLocation(), data.getValue());
        return "Datos escritos correctamente";
    }

    @GetMapping
    public List<FluxTable> readData(@RequestParam String location) {
        return sensorService.getDataByLocation(location);
    }
}
