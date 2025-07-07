package com.example.Integrador_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeRedirectController {

    @GetMapping("/")
    public String redirigirHome() {
        return "redirect:/Ecogreen/index";
    }
}

