package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.dto.PlantacionDTO;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantacionService {
    public Plantacion savePlantacion(PlantacionDTO plantacionDTO, User usuario);
    public Plantacion getPlantacionById(Long id);
    public String deletePlantacionById(Long id);
    public List<Plantacion> getAllPlantaciones();
    public List<Plantacion> getPlantacionByTipoProducto(String tipoProducto);
    public List<Plantacion> getPlantacionesByUsuario(String usuario);
}
