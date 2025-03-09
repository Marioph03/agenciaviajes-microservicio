package org.example.microservicio_hotel;

import models.Hotel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.HotelRepository;

import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"org.example.microservicio_hotel", "repository", "services"})
@EnableJpaRepositories("repository")
@EntityScan("models")
@RequestMapping("/hoteles")
public class MicroservicioHotelApplication {
    private final HotelRepository hotelRepository;

    public MicroservicioHotelApplication(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioHotelApplication.class, args);
    }

    // Devuelve la lista de hoteles en la ruta /hoteles/list
    @GetMapping("/list")
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    // Devuelve un hotel por ID en la ruta /hoteles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        return hotelRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Nuevo endpoint para crear un hotel en la ruta /hoteles/create
    @PostMapping("/create")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}