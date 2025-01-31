package com.jaroso.apiinflux.controllers;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.dto.SensorData;
import com.jaroso.apiinflux.services.SensorDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class SensorDataController {

    private final SensorDataService sensorService;


    public SensorDataController(SensorDataService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public String writeData(@RequestBody SensorData data) {
        sensorService.saveData(data.getSensorId(), data.getValue());
        return "Datos escritos correctamente";
    }

    @GetMapping
    public List<FluxTable> readData(@RequestParam Long sensorId) {
        return sensorService.getDataBySensorId(sensorId);
    }
}
