package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.Emprendedores;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Service.EmprendedorService;
import com.example.Integrador_web.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Ecogreen")
public class EmprendedorController {
    @Autowired
    private EmprendedorService emprendedorService;
    public EmprendedorController(EmprendedorService emprendedorService) {
        this.emprendedorService = emprendedorService;
    }

    @GetMapping("/login_e")
    public String mostrarIngreo() {
        return "login_e";
    }


    @PostMapping("/validar_e")

    public String validarCliente(@RequestParam("ruc") String ruc,
                                 @RequestParam("contrasena") String contrasena,
                                 Model model,
                                 HttpSession session) {
        System.out.println("Intentando validar empresa...");

        Emprendedores emprendedores = emprendedorService.validarCliente(ruc, contrasena);


        if (emprendedores != null) {

            session.setAttribute("emprendedores", emprendedores);
            // Agregar el usuario al modelo si es necesario para la vista
            model.addAttribute("emprendedores", emprendedores);

            // Redirigir al index o página principal
            return "redirect:/Ecogreen/emprendedor";

        } else {
            // Si el usuario no es válido, mostrar error
            model.addAttribute("error", "RUC o contraseña incorrectos");
            return "login_e"; // Página de login
        }
    }
    @PostMapping("/registro_e")
    public String registrarEmprendedor(@ModelAttribute Emprendedores emprendedores) {
        // Encriptar contraseña si es necesario antes de guardar
        emprendedorService.registrarEmpresa(emprendedores);
        return "redirect:/Ecogreen/login_e"; // Redirigir al login después de registrarse
    }

}
