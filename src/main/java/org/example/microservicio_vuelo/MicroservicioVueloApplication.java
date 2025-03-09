package org.example.microservicio_vuelo;

import org.example.microservicio_vuelo.model.Vuelo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.example.microservicio_vuelo.services.VuelosService;
import org.example.microservicio_vuelo.services.VuelosServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@SpringBootApplication(scanBasePackages = "org.example.microservicio_vuelo")
@EnableJpaRepositories("org.example.microservicio_vuelo.repository")
@RestController
@RequestMapping("/vuelos")
public class MicroservicioVueloApplication {

    private final VuelosService vuelosService;
    private final VuelosServiceImpl vuelosServiceImpl;

    public MicroservicioVueloApplication(VuelosService vuelosService, VuelosServiceImpl vuelosServiceImpl) {
        this.vuelosService = vuelosService;
        this.vuelosServiceImpl = vuelosServiceImpl;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioVueloApplication.class, args);
    }

    @GetMapping("/{plazas}")
    public List<Vuelo> getAvailableFlights(@PathVariable("plazas") int plazas) {
        return vuelosService.getAvailableFlights(plazas);
    }

    @PutMapping("/{flightId}/{totalPersonas}")
    public ResponseEntity<String> updateSeats(@PathVariable Long flightId, @PathVariable int totalPersonas) {
        boolean updated = vuelosService.reserveSeats(flightId, totalPersonas);
        if (updated) {
            return ResponseEntity.ok("Se actualizaron las plazas para el vuelo " + flightId);
        }
        return ResponseEntity.badRequest().body("No se pudieron actualizar las plazas para el vuelo " + flightId);
    }

    @PostMapping("/create")
    public ResponseEntity<Vuelo> createFlight(@RequestBody Vuelo vuelo) {
        Vuelo savedFlight = vuelosServiceImpl.agregarVuelo(vuelo);
        return ResponseEntity.ok(savedFlight);
    }
}