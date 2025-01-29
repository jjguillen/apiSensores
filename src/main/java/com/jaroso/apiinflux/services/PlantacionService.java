package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.entities.Plantacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantacionService {
    public void savePlantacion(Plantacion plantacion);
    public Plantacion getPlantacionById(Long id);
    public void deletePlantacionById(Long id);
    public List<Plantacion> getAllPlantaciones();
}
