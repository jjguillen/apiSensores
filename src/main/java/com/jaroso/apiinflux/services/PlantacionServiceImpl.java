package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
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
    public void savePlantacion(Plantacion plantacion) {
        plantacionRepository.save(plantacion);
    }

    @Override
    public Plantacion getPlantacionById(Long id) {
        return plantacionRepository.getPlantacionById(id).orElse(null);
    }

    @Override
    public void deletePlantacionById(Long id) {
        plantacionRepository.deleteById(id);
    }

    @Override
    public List<Plantacion> getAllPlantaciones() {
        return plantacionRepository.findAll();
    }
}
