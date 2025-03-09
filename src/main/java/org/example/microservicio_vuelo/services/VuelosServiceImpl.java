package org.example.microservicio_vuelo.services;

import org.example.microservicio_vuelo.dao.VuelosDao;
import org.example.microservicio_vuelo.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.microservicio_vuelo.repository.VueloRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VuelosServiceImpl implements VuelosService {

    @Autowired
    private VuelosDao vuelosDao;

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public List<Vuelo> getAvailableFlights(int requiredSeats) {
        List<Vuelo> allFlights = vuelosDao.findAllFlights();
        return allFlights.stream()
                .filter(flight -> flight.getPlazas() >= requiredSeats)
                .collect(Collectors.toList());
    }

    @Override
    public boolean reserveSeats(Long flightId, int totalPersonas) {
        Optional<Vuelo> optionalFlight = vueloRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            Vuelo vuelo = optionalFlight.get();
            if (vuelo.getPlazas() >= totalPersonas) {
                vuelo.setPlazas(vuelo.getPlazas() - totalPersonas);
                vueloRepository.save(vuelo);
                return true;
            }
        }
        return false;
    }

    @Override
    public Vuelo agregarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }
}