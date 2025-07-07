package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.EmpresaTop;
import com.example.Integrador_web.Model.Recompensa;
import com.example.Integrador_web.Repository.IEmpresaTop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaTopService {

    @Autowired
    private IEmpresaTop iEmpresaTop;


    public List<EmpresaTop> obtenerTop3Empresas() {
        return iEmpresaTop.obtenerTop3Empresas();
    }
}
