package com.example.Integrador_web.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Service.UsuarioService;

@Controller
@RequestMapping("/Ecogreen")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String mostrarIngreo() {
        return "login";
    }
    @PostMapping("/validar")

    public String validarCliente(@RequestParam("dni") String dni,
                                 @RequestParam("contrasena") String contrasena,
                                 Model model,
                                 HttpSession session) {
        // Validar usuario
        Usuario usuario = usuarioService.validarCliente(dni, contrasena);

        if (usuario != null) {
            // Guardar el usuario en la sesión
            session.setAttribute("usuario", usuario);
            System.out.println("Intentando validar usuario...");
            // Agregar el usuario al modelo si es necesario para la vista
            model.addAttribute("usuario", usuario);

            // Redirigir al index o página principal
            return "index";
        } else {
            // Si el usuario no es válido, mostrar error
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login"; // Página de login
        }
    }
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        // Encriptar contraseña si es necesario antes de guardar
        usuarioService.registrarUsuario(usuario);
        return "redirect:/Ecogreen/login"; // Redirigir al login después de registrarse
    }
}
