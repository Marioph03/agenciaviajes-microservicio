package org.example.microservicio_vuelo.services;

import org.example.microservicio_vuelo.model.Vuelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VuelosService {
    List<Vuelo> getAvailableFlights(int requiredSeats);
    boolean reserveSeats(Long flightId, int totalPersonas);
    Vuelo agregarVuelo(Vuelo vuelo);
}