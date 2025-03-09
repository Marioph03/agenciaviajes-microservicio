package org.example.microservicio_reserva.controller;

import org.example.microservicio_reserva.model.Reserva;
import org.example.microservicio_reserva.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        return reservaService.getReservaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva savedReserva = reservaService.createReserva(reserva);
        return ResponseEntity.ok(savedReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        if (reservaService.deleteReserva(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}