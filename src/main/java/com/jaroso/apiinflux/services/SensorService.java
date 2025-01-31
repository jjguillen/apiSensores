package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.entities.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SensorService {
    public void saveSensor(Sensor sensor);
    public Sensor getSensorById(Long id);
    public void deleteSensorById(Long id);
    public List<Sensor> getAllSensores();
    public List<Sensor> getSensoresByTipoAndPlantacion(Sensor.Tipo tipo, Long idPlantacion);
    public List<Sensor> getSensoresByPlantacion(Long idPlantacion);

}
