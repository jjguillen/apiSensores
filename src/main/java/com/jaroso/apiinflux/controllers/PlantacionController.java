package com.jaroso.apiinflux.controllers;

import com.influxdb.query.FluxTable;
import com.jaroso.apiinflux.dto.PlantacionDTO;
import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.repositories.UserRepository;
import com.jaroso.apiinflux.security.JwtFilter;
import com.jaroso.apiinflux.services.PlantacionService;
import com.jaroso.apiinflux.services.SensorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
@RequestMapping("/api/plantaciones")
public class PlantacionController {

    private final PlantacionService plantacionService;
    private final SensorService sensorService;
    private final JwtFilter jwtFilter;
    private final UserRepository userRepository;

    public PlantacionController(PlantacionService plantacionService, SensorService sensorService, JwtFilter jwtFilter, UserRepository userRepository) {
        this.plantacionService = plantacionService;
        this.sensorService = sensorService;
        this.jwtFilter = jwtFilter;
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<Plantacion> getAll() {
        return plantacionService.getAllPlantaciones();
    }

    @GetMapping("/{idPlantacion}/sensores")
    public List<Sensor> getSensoresByPlantacion(@PathVariable String idPlantacion) {
        return sensorService.getSensoresByPlantacion(Long.valueOf(idPlantacion));
    }

    @GetMapping("/{idPlantacion}/tipo/sensores")
    public List<Sensor> getSensoresByPlantacionAndTipo(@PathVariable String idPlantacion, @RequestParam String tipo) {
        return sensorService.getSensoresByTipoAndPlantacion(Sensor.Tipo.valueOf(tipo), Long.valueOf(idPlantacion));
    }

    @PostMapping
    public Plantacion savePlantacion(HttpServletRequest request, @RequestBody PlantacionDTO plantacionDTO) {
        String token = jwtFilter.extractToken(request);
        if (token != null) {
            String userName = jwtFilter.jwtUtil.getUsernameFromToken(token);
            if (userName != null) {
                User user = userRepository.findUserByUsername(userName).orElse(null);
                if (user != null) {
                    return plantacionService.savePlantacion(plantacionDTO, user);
                }
            } else {
                throw new RuntimeException("Usuario no encontrada");
            }
        } else {
            throw new RuntimeException("Token no encontrado");
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletePlantacion(@PathVariable String id) {
        return plantacionService.deletePlantacionById(Long.valueOf(id));
    }

    @GetMapping("/usuario")
    public List<Plantacion> getPlantacionesByUsuario(HttpServletRequest request) {
        String token = jwtFilter.extractToken(request);
        if (token != null) {
            String userName = jwtFilter.jwtUtil.getUsernameFromToken(token);
            if (userName != null) {
                User user = userRepository.findUserByUsername(userName).orElse(null);
                if (user != null) {
                    return plantacionService.getPlantacionesByUsuario(user.getUsername());
                }
            } else {
                throw new RuntimeException("Usuario no encontrada");
            }
        } else {
            throw new RuntimeException("Token no encontrado");
        }
        return null;
    }

}
