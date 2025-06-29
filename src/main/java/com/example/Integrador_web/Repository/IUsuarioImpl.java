package com.example.Integrador_web.Repository;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Conexion.conexionBD;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IUsuarioImpl implements IUsuario {
    private final BCryptPasswordEncoder passwordEncoder;

    // Inyectar BCryptPasswordEncoder
    public IUsuarioImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public  Usuario validarCliente(String dni, String contrasena) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE dni = ? AND password_hash = ?";



        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, dni);
            stmt.setString(2, contrasena);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre_completo"),
                            rs.getString("nombre_usuario"),
                            rs.getString("correo_electronico"),
                            rs.getString("password_hash"),
                            rs.getString("fecha_registro"),
                            rs.getString("dni")

                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    @Override
    public void registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre_completo, dni, correo_electronico, nombre_usuario, password_hash) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setString(2, usuario.getDni());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getNombreUsuario());
            stmt.setString(5, usuario.getContrasena()); // ⚠️ Cifra si es posible

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
