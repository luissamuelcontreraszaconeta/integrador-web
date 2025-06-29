package com.example.Integrador_web.Service;

import com.example.Integrador_web.Repository.IInscripcionEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Integrador_web.Model.Eventos;
import com.example.Integrador_web.Repository.IEventos;

import java.util.List;

@Service
public class EventosService {
    @Autowired
    private  IEventos iEventos;
    private IInscripcionEvento iInscripciones;



    public List<Eventos> listareventos() {
        return iEventos.ListarEvento();
    }


    public void guardar(Eventos eventos) {
        iEventos.guardar(eventos);
    }

    public boolean estaInscrito(int idUsuario,int idEvento) {
        return iInscripciones.existeInscripcion(idUsuario, idEvento);
    }

}
