package org.example.microservicio_reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "org.example.microservicio_reserva",
        "org.example.microservicio_reserva.repository",
        "org.example.microservicio_reserva.services"
})
@EnableJpaRepositories("org.example.microservicio_reserva.repository")
@EntityScan("org.example.microservicio_reserva.model") // Escanea las entidades en este paquete.
public class MicroservicioReservaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroservicioReservaApplication.class, args);
    }
}
