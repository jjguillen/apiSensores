package com.jaroso.apiinflux.repositories;

import com.jaroso.apiinflux.entities.Plantacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantacionRepository extends JpaRepository<Plantacion, Long> {

    Optional<Plantacion> getPlantacionById(Long id);
}
