package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.dto.SensorDTO;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import com.jaroso.apiinflux.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final PlantacionRepository plantacionRepository;

    public SensorServiceImpl(SensorRepository sensorRepository, PlantacionRepository plantacionRepository) {
        this.sensorRepository = sensorRepository;
        this.plantacionRepository = plantacionRepository;
    }

    @Override
    public Sensor saveSensor(SensorDTO sensorDTO) {
        Optional<Plantacion> plantacionOpt = plantacionRepository.findById(sensorDTO.getPlantacionId());

        if (plantacionOpt.isEmpty()) {
            throw new RuntimeException("Plantación no encontrada");
        }

        Sensor sensor = new Sensor();
        sensor.setTipo(Sensor.Tipo.valueOf(sensorDTO.getTipo()));
        sensor.setPlantacion(plantacionOpt.get());
        sensor.setUbicLatitud(sensorDTO.getUbicLatitud());
        sensor.setUbicLongitud(sensorDTO.getUbicLongitud());
        sensor.setUnidadMedida(sensorDTO.getUnidadMedida());

        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
        return "Sensor " + id + " eliminado";
    }

    @Override
    public List<Sensor> getAllSensores() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Sensor> getSensoresByTipoAndPlantacion(Sensor.Tipo tipo, Long idPlantacion) {
        Plantacion plantacion = plantacionRepository.findPlantacionById(idPlantacion).orElse(null);
        if (plantacion == null) {
            return List.of();
        } else
            return sensorRepository.findByTipoAndPlantacion(tipo, plantacion);
    }

    @Override
    public List<Sensor> getSensoresByPlantacion(Long idPlantacion) {
        Plantacion plantacion = plantacionRepository.findPlantacionById(idPlantacion).orElse(null);
        if (plantacion == null) {
            return List.of();
        } else
            return sensorRepository.findByPlantacion(plantacion);
    }
}
