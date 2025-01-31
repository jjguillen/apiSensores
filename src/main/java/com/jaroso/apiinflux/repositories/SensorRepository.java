package com.jaroso.apiinflux.repositories;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    List<Sensor> findByTipoAndPlantacion(Sensor.Tipo tipo, Plantacion plantacion);
    List<Sensor> findByPlantacion(Plantacion plantacion);


}
