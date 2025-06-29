package com.example.Integrador_web.Controller;
import com.example.Integrador_web.Model.Inscripciones;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Service.InscripcionesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller

public class InscripcionEventoController {

    @Autowired
    private InscripcionesService inscripcionesService;

    @PostMapping("/eventos/{idEvento}/inscribirse")
    public String inscribirseEvento(@PathVariable("idEvento") int idEvento, HttpSession session) {
        // Verificar si hay un usuario logueado
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/Ecogreen/login";
        }

        // Crear una nueva inscripción
        Inscripciones inscripcion = new Inscripciones();
        inscripcion.setId_evento(idEvento);
        inscripcion.setId_usuario(usuario.getIdUsuario());

        // Registrar la fecha de inscripción actual
        Timestamp fechaActual = Timestamp.valueOf(LocalDateTime.now());
        inscripcion.setFecha_inscripcion(fechaActual);
        // Puedes poner false como valor inicial de asistencia
        inscripcion.setAsistencia(false);

        // Guardar inscripción
        inscripcionesService.guardar(inscripcion);

        return "redirect:/Ecogreen/voluntariado"; // Redirige de vuelta a la lista de eventos
    }

    @PostMapping("/eventos/{idEvento}/cancelar")
    public String cancelarInscripcion(@PathVariable("idEvento") int idEvento, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/Ecogreen/login";
        }

        inscripcionesService.eliminarInscripcion(usuario.getIdUsuario(), idEvento);
        return "redirect:/Ecogreen/voluntariado";
    }

}
