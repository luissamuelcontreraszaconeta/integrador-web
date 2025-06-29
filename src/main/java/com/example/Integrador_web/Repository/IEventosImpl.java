package com.example.Integrador_web.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Integrador_web.Model.Eventos;
import com.example.Integrador_web.Conexion.conexionBD;
import org.springframework.stereotype.Repository;


@Repository
public class IEventosImpl implements IEventos {

    @Override
    public void guardar(Eventos evento) {
        String query = "INSERT INTO eventos (id_creador, nombre_evento, fecha, hora, ubicacion, descripcion) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, evento.getId_creador());
            stmt.setString(2, evento.getNombre_evento());
            stmt.setString(3, evento.getFecha());
            stmt.setString(4, evento.getHora());
            stmt.setString(5, evento.getUbicacion());
            stmt.setString(6, evento.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Eventos> ListarEvento() {
        List<Eventos> Eventos = new ArrayList<>();
        String query = "SELECT e.id_evento, e.id_creador, e.nombre_evento, e.fecha, e.hora, e.ubicacion, e.link_ubicacion, e.descripcion, e.fecha_creacion, em.nombre_empresa " +
                "FROM eventos e " +
                "INNER JOIN empresas em ON e.id_empresa = em.id_empresa";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Eventos eventos = new Eventos();
                eventos.setId_evento(rs.getInt("id_evento"));
                eventos.setId_creador(rs.getInt("id_creador"));
                eventos.setNombre_evento(rs.getString("nombre_evento"));
                eventos.setFecha(rs.getString("fecha"));
                eventos.setHora(rs.getString("hora"));
                eventos.setUbicacion(rs.getString("ubicacion"));
                eventos.setLink_ubicacion(rs.getString("link_ubicacion"));
                eventos.setDescripcion(rs.getString("descripcion"));
                eventos.setFecha_creacion(rs.getString("fecha_creacion"));
                eventos.setEmpresa(rs.getString("nombre_empresa")); // 👈 Agregado

                Eventos.add(eventos);
            }

    } catch (SQLException e) {
            e.printStackTrace();
        }
        return Eventos;
    }
}
