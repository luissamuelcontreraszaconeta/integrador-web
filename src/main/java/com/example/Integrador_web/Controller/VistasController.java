package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.*;
import com.example.Integrador_web.Service.EventosService;
import com.example.Integrador_web.Service.ForosService;
import com.example.Integrador_web.Service.InscripcionesService;
import com.example.Integrador_web.Service.PublicacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Ecogreen")
public class VistasController
{
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


    @Autowired
    private EventosService eventosService;
    @Autowired
    private InscripcionesService inscripcionService;

    @Autowired
    private ForosService forosService;

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping("/voluntariados_e")
    public String mostrarEventosPublicos(Model model) {
        List<Eventos> listaEventos = eventosService.listareventos();
        model.addAttribute("eventos", listaEventos);

        Map<Integer, List<Inscripciones>> participantesPorEvento = new HashMap<>();

        for (Eventos evento : listaEventos) {
            List<Inscripciones> participantes = inscripcionService.listarPorEvento(evento.getId_evento());
            participantesPorEvento.put(evento.getId_evento(), participantes);
        }

        model.addAttribute("participantesPorEvento", participantesPorEvento);

        return "voluntariados_e"; // Aquí tu vista HTML adaptada
    }


    @GetMapping("/foro_e")
    public String mostrarForo(Model model, HttpSession session) {
        List<Foros> listaForos = forosService.listarforo();
        Map<Integer, List<Publicaciones>> respuestasPorForo = new HashMap<>();

        for (Foros foro : listaForos) {
            List<Publicaciones> respuestas = publicacionService.obtenerPublicacionesPorTema(foro.getId_tema());
            respuestasPorForo.put(foro.getId_tema(), respuestas);
        }

        model.addAttribute("foros", listaForos);
        model.addAttribute("respuestasPorForo", respuestasPorForo);

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuarioLogueado", usuario);

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
