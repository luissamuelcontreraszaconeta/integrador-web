package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Conexion.conexionBD;
import com.example.Integrador_web.Model.Apartados;
import com.example.Integrador_web.Model.Foros;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class IApartadoImpl implements IApartado{

    @Override
    public Apartados obtenerApartadoFijo() {
        Apartados apartado = null;
        String query = "SELECT * FROM apartados WHERE id_apartado = 1";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                apartado = new Apartados();
                apartado.setTituloB(rs.getString("titulo"));
                apartado.setContenidoB(rs.getString("contenido"));
                apartado.setRutaB(rs.getString("ruta_imagen"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apartado;
    }

    @Override
    public Apartados obtenerApartadoFijoA() {
        Apartados apartado = null;
        String query = "SELECT * FROM apartados WHERE id_apartado = 2";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                apartado = new Apartados();
                apartado.setTituloA(rs.getString("titulo"));
                apartado.setContenidoA(rs.getString("contenido"));
                apartado.setRutaA(rs.getString("ruta_imagen"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apartado;
    }

    @Override
    public Apartados obtenerApartadoFijoV() {
        Apartados apartado = null;
        String query = "SELECT * FROM apartados WHERE id_apartado = 3";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                apartado = new Apartados();
                apartado.setTituloV(rs.getString("titulo"));
                apartado.setContenidoV(rs.getString("contenido"));
                apartado.setRutaV(rs.getString("ruta_imagen"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apartado;
    }

}
