package com.jaroso.apiinflux;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiInfluxApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(ApiInfluxApplication.class, args);
        var plantacionRepository = context.getBean(PlantacionRepository.class);

        List<Plantacion> plantaciones = List.of(
                new Plantacion("Trops-1", "36.721261, -4.421265", "Mango"),
                new Plantacion("Trops-2", "37.721261, -4.521265", "Aguacate")
        );
        plantacionRepository.saveAll(plantaciones);
    }

}
