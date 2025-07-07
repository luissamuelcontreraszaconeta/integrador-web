package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.EmpresaTop;
import com.example.Integrador_web.Service.EmpresaTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Ecogreen")
public class EmpresaTopController {
    @Autowired
    private EmpresaTopService empresaService; // o el servicio que llame a tu repositorio

    @GetMapping("/index")
    public String mostrarTopEmpresas(Model model) {
        List<EmpresaTop> topEmpresas = empresaService.obtenerTop3Empresas();
        model.addAttribute("topEmpresas", topEmpresas);
        return "index"; // este es el nombre del HTML
    }

//
//    @GetMapping("/")
//    public String redirigirInicio() {
//        return "redirect:/Ecogreen/index";
//    }

}





