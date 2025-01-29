package com.jaroso.apiinflux.controllers;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.services.PlantacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plantaciones")
public class PlantacionController {

    private final PlantacionService plantacionService;

    public PlantacionController(PlantacionService plantacionService) {
        this.plantacionService = plantacionService;
    }

    @GetMapping
    public List<Plantacion> getAll() {
        return plantacionService.getAllPlantaciones();
    }


}
