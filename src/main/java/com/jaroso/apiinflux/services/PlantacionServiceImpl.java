package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.dto.PlantacionDTO;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import com.jaroso.apiinflux.repositories.SensorRepository;
import com.jaroso.apiinflux.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantacionServiceImpl implements PlantacionService {

    private final PlantacionRepository plantacionRepository;
    private final UserRepository userRepository;

    public PlantacionServiceImpl(PlantacionRepository plantacionRepository, UserRepository userRepository) {
        this.plantacionRepository = plantacionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Plantacion savePlantacion(PlantacionDTO plantacionDTO) {
        User usuario = userRepository.findById(plantacionDTO.getUsuarioId()).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrada");
        }

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
    public List<Plantacion> getPlantacionesByUsuario(Long idUsuario) {
        return plantacionRepository.findPlantacionByUsuarioId(idUsuario);
    }

}
