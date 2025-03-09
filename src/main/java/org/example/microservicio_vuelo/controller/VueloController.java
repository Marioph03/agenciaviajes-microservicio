package org.example.microservicio_vuelo.controller;

import org.example.microservicio_vuelo.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.example.microservicio_vuelo.services.VuelosService;

import java.util.List;

@RestController
@Controller
@RequestMapping("/vuelos")
class VueloController {
    @Autowired
    private VuelosService vuelosService;

    @GetMapping("/listar")
    public String listarVuelos(@RequestParam(name = "plazas", defaultValue = "1") int plazas, Model model) {
        List<Vuelo> vuelos = vuelosService.getAvailableFlights(plazas);
        model.addAttribute("vuelos", vuelos);
        return "index"; // Renderiza vuelo.html
    }

    @GetMapping("/reservar")
    public String mostrarReservarVuelo(Model model) {
        model.addAttribute("reservarForm", true);
        return "index";
    }

    @PostMapping("/reservar")
    public String reservarVuelo(@RequestParam("vueloId") Long vueloId,
                                @RequestParam("plazasSolicitadas") int plazasSolicitadas,
                                RedirectAttributes redirectAttributes) {
        boolean exito = vuelosService.reserveSeats(vueloId, plazasSolicitadas);
        redirectAttributes.addFlashAttribute("mensaje", exito ? "Reserva realizada" : "No hay plazas suficientes");
        return "redirect:/listar";
    }

    @GetMapping("/agregar")
    public String mostrarAgregarVuelo(Model model) {
        model.addAttribute("agregarForm", true);
        return "index";
    }

    @PostMapping("/agregar")
    public String agregarVuelo(Vuelo vuelo, RedirectAttributes redirectAttributes) {
        // Suponiendo que tienes un método en VuelosService para agregar vuelos:
        vuelosService.agregarVuelo(vuelo);
        redirectAttributes.addFlashAttribute("mensaje", "Vuelo agregado correctamente");
        return "redirect:/listar";
    }
}