package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.Inscripciones;
import com.example.Integrador_web.Repository.IInscripcionEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscripcionesService {

    @Autowired
    private IInscripcionEvento iInscripciones;

    public void guardar(Inscripciones inscripcion) {
        iInscripciones.guardarInscripcion(inscripcion);
    }

    // Si luego quieres listar inscritos por evento, puedes agregar:
    public List<Inscripciones> listarPorEvento(int idEvento) {
        return iInscripciones.listarInscripcionesPorEvento(idEvento);
    }

    public boolean estaInscrito(int idUsuario,int idEvento) {
        return iInscripciones.existeInscripcion(idUsuario, idEvento);
    }

    public void eliminarInscripcion(int idUsuario, int idEvento) {
        iInscripciones.eliminarInscripcion(idUsuario, idEvento);
    }


}
