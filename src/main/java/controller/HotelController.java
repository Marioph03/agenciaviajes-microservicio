package controller;

import models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/disponibles")
    public List<Hotel> getHotelesDisponibles() {
        return hotelService.getHotelesDisponibles();
    }
}
