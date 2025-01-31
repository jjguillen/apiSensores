package com.jaroso.apiinflux.services;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.repositories.InfluxDBRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorDataService {

    private final InfluxDBRepository influxDBRepository;

    public SensorDataService(InfluxDBRepository influxDBRepository) {
        this.influxDBRepository = influxDBRepository;
    }

    public void saveData(Long sensorId, double value) {
        //Falta sacar el tipo de sensor haciendo una consulta a la base de datos
        influxDBRepository.saveData(sensorId, value);
    }

    public List<FluxTable> getDataBySensorId(Long sensorId) {
        return influxDBRepository.getDataBySensorId(sensorId);
    }
}
