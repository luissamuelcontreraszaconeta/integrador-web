package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.Apartados;
import com.example.Integrador_web.Service.ApartadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Ecogreen")
public class ApartadoController {

    @Autowired
    private ApartadosService apartadosService;

    @GetMapping("/contaminacion")
    public String mostrarApartadoBasura(Model model) {
        Apartados apartado = apartadosService.obtenerApartadoPorDefecto(); // ID = 1
        model.addAttribute("apartado", apartado);
        return "contaminacion"; // nombre de tu plantilla HTML
    }



    @GetMapping("/agua")
    public String mostrarApartadoAgua(Model model) {
        Apartados apartado = apartadosService.obtenerApartadoPorDefectoA(); // ID = 1
        model.addAttribute("apartado", apartado);
        return "agua"; // nombre de tu plantilla HTML
    }


    @GetMapping("/areas_verdes")
    public String mostrarApartadoVerde(Model model) {
        Apartados apartado = apartadosService.obtenerApartadoPorDefectoV(); // ID = 1
        model.addAttribute("apartado", apartado);
        return "areas_verdes"; // nombre de tu plantilla HTML
    }
}

