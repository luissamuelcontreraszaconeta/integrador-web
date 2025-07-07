package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.Apartados;
import com.example.Integrador_web.Repository.IApartado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartadosService {

    @Autowired
    private IApartado apartadoRepository; // Tu interfaz

    public Apartados obtenerApartadoPorDefecto() {
        return apartadoRepository.obtenerApartadoFijo();
    }

    public Apartados obtenerApartadoPorDefectoA() {
        return apartadoRepository.obtenerApartadoFijoA();
    }

    public Apartados obtenerApartadoPorDefectoV() {
        return apartadoRepository.obtenerApartadoFijoV();
    }


}
