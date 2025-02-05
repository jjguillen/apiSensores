package com.jaroso.apiinflux.controllers;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.dto.SensorData;
import com.jaroso.apiinflux.services.SensorDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class SensorDataController {

    private final SensorDataService sensorDataService;


    public SensorDataController(SensorDataService sensorService, SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @PostMapping
    public String writeData(@RequestBody SensorData data) {
        sensorDataService.saveData(data.getSensorId(), data.getValue());
        return "Datos escritos correctamente";
    }

    @GetMapping("/{sensorId}")
    public List<FluxTable> readData(@PathVariable Long sensorId) {
        return sensorDataService.getDataBySensorId(sensorId);
    }

    @GetMapping("/hour/{sensorId}")
    public List<FluxTable> readDataOneHour(@PathVariable Long sensorId) {
        return sensorDataService.getDataOneHourBySensorId(sensorId);
    }

    @GetMapping("/day/{sensorId}")
    public List<FluxTable> readDataOneDay(@PathVariable Long sensorId) {
        return sensorDataService.getDataOneDayBySensorId(sensorId);
    }
}
