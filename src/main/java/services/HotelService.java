package services;

import models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HotelRepository;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getHotelesDisponibles() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel agregarHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void eliminarHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
