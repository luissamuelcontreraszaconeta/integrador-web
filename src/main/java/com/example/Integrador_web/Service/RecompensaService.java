package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.Foros;
import com.example.Integrador_web.Model.Recompensa;
import com.example.Integrador_web.Repository.IRecompensa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RecompensaService {

    @Autowired
    private IRecompensa recompensaRepo;

    public List<Recompensa> obtenerRecompensasPorUsuario(int idUsuario) {
        return recompensaRepo.listarRecompensasPorUsuario(idUsuario);
    }
}

