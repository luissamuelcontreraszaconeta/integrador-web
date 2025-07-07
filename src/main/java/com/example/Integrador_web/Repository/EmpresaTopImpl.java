package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Conexion.conexionBD;
import com.example.Integrador_web.Model.EmpresaTop;
import org.springframework.stereotype.Repository;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class EmpresaTopImpl implements IEmpresaTop{
    @Override
    public List<EmpresaTop> obtenerTop3Empresas() {
        List<EmpresaTop> lista = new ArrayList<>();
        String sql = """
        SELECT e.id_empresa, e.nombre_empresa, SUM(r.cantidad) AS total_kg
        FROM residuos r
        JOIN empresas e ON r.id_empresa = e.id_empresa
        GROUP BY e.id_empresa, e.nombre_empresa
        ORDER BY total_kg DESC
        LIMIT 3
        """;

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EmpresaTop empresa = new EmpresaTop();
                empresa.setIdEmpresa(rs.getInt("id_empresa"));
                empresa.setNombreEmpresa(rs.getString("nombre_empresa"));
                empresa.setTotalKg(rs.getInt("total_kg"));
                lista.add(empresa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


}
