package com.jaroso.apiinflux.repositories;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantacionRepository extends JpaRepository<Plantacion, Long> {

    Optional<Plantacion> findPlantacionById(Long id);
    List<Plantacion> findPlantacionByTipoProducto(String tipoProducto);
    List<Plantacion> findPlantacionByUsuarioId(Long idUsuario);
    List<Plantacion> findPlantacionByUsuarioUsername(String username);
}
