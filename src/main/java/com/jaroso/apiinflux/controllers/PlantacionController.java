package com.jaroso.apiinflux.controllers;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.services.PlantacionService;
import com.jaroso.apiinflux.services.SensorService;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
@RequestMapping("/api/plantaciones")
public class PlantacionController {

    private final PlantacionService plantacionService;
    private final SensorService sensorService;

    public PlantacionController(PlantacionService plantacionService, SensorService sensorService) {
        this.plantacionService = plantacionService;
        this.sensorService = sensorService;
    }


    @GetMapping
    public List<Plantacion> getAll() {
        return plantacionService.getAllPlantaciones();
    }

    @GetMapping("/{idPlantacion}/sensores")
    public List<Sensor> getSensoresByPlantacion(@PathVariable String idPlantacion) {
        return sensorService.getSensoresByPlantacion(Long.valueOf(idPlantacion));
    }

    @GetMapping("/{idPlantacion}/tipo/sensores")
    public List<Sensor> getSensoresByPlantacionAndTipo(@PathVariable String idPlantacion, @RequestParam String tipo) {
        return sensorService.getSensoresByTipoAndPlantacion(Sensor.Tipo.valueOf(tipo), Long.valueOf(idPlantacion));
    }

    @PostMapping
    public Plantacion savePlantacion(@RequestBody Plantacion plantacion) {
        return plantacionService.savePlantacion(plantacion);
    }

    @DeleteMapping("/{id}")
    public String deletePlantacion(@PathVariable String id) {
        return plantacionService.deletePlantacionById(Long.valueOf(id));
    }

}
