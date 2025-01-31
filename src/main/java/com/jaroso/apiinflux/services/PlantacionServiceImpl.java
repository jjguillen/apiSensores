package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import com.jaroso.apiinflux.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantacionServiceImpl implements PlantacionService {

    private final PlantacionRepository plantacionRepository;

    public PlantacionServiceImpl(PlantacionRepository plantacionRepository) {
        this.plantacionRepository = plantacionRepository;
    }

    @Override
    public Plantacion savePlantacion(Plantacion plantacion) {
        return plantacionRepository.save(plantacion);
    }

    @Override
    public Plantacion getPlantacionById(Long id) {
        return plantacionRepository.findPlantacionById(id).orElse(null);
    }

    @Override
    public String deletePlantacionById(Long id) {
        plantacionRepository.deleteById(id);
        return "Plantación " + id + " eliminada";
    }

    @Override
    public List<Plantacion> getAllPlantaciones() {
        return plantacionRepository.findAll();
    }

    @Override
    public List<Plantacion> getPlantacionByTipoProducto(String tipoProducto) {
        return plantacionRepository.findPlantacionByTipoProducto(tipoProducto);
    }

}
