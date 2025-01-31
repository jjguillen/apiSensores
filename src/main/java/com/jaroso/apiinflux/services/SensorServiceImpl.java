package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import com.jaroso.apiinflux.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final PlantacionRepository plantacionRepository;

    public SensorServiceImpl(SensorRepository sensorRepository, PlantacionRepository plantacionRepository) {
        this.sensorRepository = sensorRepository;
        this.plantacionRepository = plantacionRepository;
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
    }

    @Override
    public List<Sensor> getAllSensores() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Sensor> getSensoresByTipoAndPlantacion(Sensor.Tipo tipo, Long idPlantacion) {
        Plantacion plantacion = plantacionRepository.getPlantacionById(idPlantacion).orElse(null);
        if (plantacion == null) {
            return List.of();
        } else
            return sensorRepository.findByTipoAndPlantacion(tipo, plantacion);
    }

    @Override
    public List<Sensor> getSensoresByPlantacion(Long idPlantacion) {
        Plantacion plantacion = plantacionRepository.getPlantacionById(idPlantacion).orElse(null);
        if (plantacion == null) {
            return List.of();
        } else
            return sensorRepository.findByPlantacion(plantacion);
    }
}
