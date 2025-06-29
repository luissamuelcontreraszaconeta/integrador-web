package com.example.Integrador_web.Repository;

import java.util.List;
import com.example.Integrador_web.Model.Inscripciones;

public interface IInscripcionEvento {

    void guardarInscripcion(Inscripciones inscripcion);

    List<Inscripciones> listarInscripcionesPorEvento(int idEvento);

    boolean existeInscripcion(int idUsuario, int idEvento);

    void eliminarInscripcion(int idUsuario, int idEvento);
}
