package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Conexion.conexionBD;
import com.example.Integrador_web.Model.Recompensa;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class IRecompensaImpl implements IRecompensa{
    @Override
    public List<Recompensa> listarRecompensasPorUsuario(int idUsuario) {
        List<Recompensa> recompensas = new ArrayList<>();
        String query = "SELECT id_recompensa, id_usuario, id_empresa, nombre, fecha_venc FROM recompensas WHERE id_usuario = ?";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Recompensa r = new Recompensa();
                r.setId_recompensa(rs.getInt("id_recompensa"));
                r.setId_usuario(rs.getInt("id_usuario"));
                r.setId_empresa(rs.getInt("id_empresa"));
                r.setNombre(rs.getString("nombre"));
                r.setFecha_venc(rs.getString("fecha_venc"));

                recompensas.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recompensas;
    }


}
