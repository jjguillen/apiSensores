package com.jaroso.apiinflux;

import com.jaroso.apiinflux.entities.Plantacion;
import com.jaroso.apiinflux.entities.Sensor;
import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.repositories.PlantacionRepository;
import com.jaroso.apiinflux.repositories.SensorRepository;
import com.jaroso.apiinflux.repositories.UserRepository;
import com.jaroso.apiinflux.security.PasswordEncoderConfig;
import com.jaroso.apiinflux.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ApiInfluxApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(ApiInfluxApplication.class, args);
        var plantacionRepository = context.getBean(PlantacionRepository.class);
        var sensorRepository = context.getBean(SensorRepository.class);
        var userRepository = context.getBean(UserRepository.class);
        var passworEncoder = context.getBean(PasswordEncoder.class);

        //Creamos 1 usuario
        User user = new User();
        user.setUsername("user1");
        user.setEmail("user1@gmail.com");
        user.setPassword(passworEncoder.encode("12345678"));
        userRepository.save(user);

        Plantacion pl1 = new Plantacion("Trops-1", "36.721261, -4.421265", "España",
                "Almería", "Cuevas", "Mango",user);
        Plantacion pl2 = new Plantacion("Trops-2", "37.721261, -4.521265", "España",
                "Almería", "Vera", "Aguacate", user);

        List<Plantacion> plantaciones = List.of(pl1, pl2);
        plantacionRepository.saveAll(plantaciones);

        Sensor sr1 = new Sensor(Sensor.Tipo.TEMPERATURA, "ºC", 18.1, 1.2, pl1);
        Sensor sr2 = new Sensor(Sensor.Tipo.VIENTO, "m/s", 18.2, 1.2, pl1);

        Sensor sr3 = new Sensor(Sensor.Tipo.TEMPERATURA, "ºC", 11.1, 1.3, pl2);
        Sensor sr4 = new Sensor(Sensor.Tipo.VIENTO, "m/s", 18.5, 1.2, pl2);

        List<Sensor> sensores = List.of(sr1, sr2, sr3, sr4);
        sensorRepository.saveAll(sensores);




    }

}
