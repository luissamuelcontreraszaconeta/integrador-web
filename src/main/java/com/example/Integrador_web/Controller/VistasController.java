package com.example.Integrador_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Ecogreen")
public class VistasController
{
//
//    @GetMapping("/index")
//    public String mostrarIndex() {
//        return "index";
//    }
//    @GetMapping("/contaminacion")
//    public String mostrarHamburguesas() {
//        return "contaminacion";
//    }
//    @GetMapping("/agua")
//    public String mostraragua() {
//        return "agua";
//    }
//    @GetMapping("/areas_verdes")
//    public String area_verde() {
//        return "areas_verdes";
//    }
    @GetMapping("/reciclaje")
    public String resciclaje() {
        return "reciclaje";
    }


    @GetMapping("/voluntariados_e")
    public String Voluntariadoe() {
        return "voluntariados_e";
    }
    @GetMapping("/foro_e")
    public String foro_e() {
        return "foro_e";
    }
    @GetMapping("/dash")
    public String dash() {
        return "dash";
    }
    @GetMapping("/emprendedor")
    public String emprendedor_e() {
        return "emprendedor";
    }


    @GetMapping("/seleccion")
    public String seleccion() {
        return "seleccion";
    }

}
