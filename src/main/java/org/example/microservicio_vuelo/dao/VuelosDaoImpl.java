package org.example.microservicio_vuelo.dao;

import org.example.microservicio_vuelo.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.example.microservicio_vuelo.repository.VueloRepository;

import java.util.List;

@Repository
class VuelosDaoImpl implements VuelosDao {

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public List<Vuelo> findAllFlights() {
        return vueloRepository.findAll();
    }
}