package org.example.microservicio_vuelo.dao;

import org.example.microservicio_vuelo.model.Vuelo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VuelosDao {
    List<Vuelo> findAllFlights();
}
