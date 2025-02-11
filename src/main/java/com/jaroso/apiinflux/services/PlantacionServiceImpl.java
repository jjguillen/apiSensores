package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.dto.PlantacionDTO;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import com.jaroso.apiinflux.repositories.SensorRepository;
import com.jaroso.apiinflux.repositories.UserRepository;
import com.jaroso.apiinflux.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantacionServiceImpl implements PlantacionService {

    private final PlantacionRepository plantacionRepository;
    private final UserRepository userRepository;

    public PlantacionServiceImpl(PlantacionRepository plantacionRepository, UserRepository userRepository, JwtUtil jwUtil) {
        this.plantacionRepository = plantacionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Plantacion savePlantacion(PlantacionDTO plantacionDTO, User usuario) {

        Plantacion plantacion = new Plantacion();
        plantacion.setNombre(plantacionDTO.getNombre());
        plantacion.setTipoProducto(plantacionDTO.getTipoProducto());
        plantacion.setUbicacion(plantacionDTO.getUbicacion());
        plantacion.setPais(plantacionDTO.getPais());
        plantacion.setProvincia(plantacionDTO.getProvincia());
        plantacion.setCiudad(plantacionDTO.getCiudad());
        plantacion.setUsuario(usuario);

        return plantacionRepository.save(plantacion);
    }

    @Override
    public Plantacion getPlantacionById(Long id) {
        return plantacionRepository.findPlantacionById(id).orElse(null);
    }

    @Override
    public String deletePlantacionById(Long id) {
        plantacionRepository.deleteById(id);
        return "Plantación " + id + " eliminada";
    }

    @Override
    public List<Plantacion> getAllPlantaciones() {
        return plantacionRepository.findAll();
    }

    @Override
    public List<Plantacion> getPlantacionByTipoProducto(String tipoProducto) {
        return plantacionRepository.findPlantacionByTipoProducto(tipoProducto);
    }

    @Override
    public List<Plantacion> getPlantacionesByUsuario(String usuario) {
        return plantacionRepository.findPlantacionByUsuarioUsername(usuario);
    }

}
