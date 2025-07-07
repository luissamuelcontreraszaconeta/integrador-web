package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.Recompensa;
import com.example.Integrador_web.Model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.example.Integrador_web.Service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Ecogreen")
public class RecompensaController {

    @Autowired
    private RecompensaService recompensaService;

    @GetMapping("/mis-recompensas")
    public String mostrarRecompensas(Model model, HttpSession session) {
        // Obtener usuario logueado desde la sesión
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Validación por si no hay sesión activa
        if (usuario == null) {
            return "redirect:/Ecogreen/login";
        }

        // Obtener recompensas por ID de usuario
        List<Recompensa> recompensas = recompensaService.obtenerRecompensasPorUsuario(usuario.getIdUsuario());

        // Enviar a la vista
        model.addAttribute("recompensas", recompensas);
        return "recompensas";  // nombre del archivo HTML sin extensión
    }
}

