package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Model.Eventos;
import com.example.Integrador_web.Model.Recompensa;

import java.util.List;

public interface IRecompensa {
    List<Recompensa> listarRecompensasPorUsuario(int idUsuario);

}
