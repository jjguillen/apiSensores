package com.jaroso.apiinflux.repositories;

import com.jaroso.apiinflux.entities.Plantacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantacionRepository extends JpaRepository<Plantacion, Long> {
}
