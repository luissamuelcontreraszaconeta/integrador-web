package com.example.Integrador_web.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.example.Integrador_web.Model.Inscripciones;
import com.example.Integrador_web.Conexion.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class    InscripcionEventoImpl implements IInscripcionEvento {

    @Override
    public void guardarInscripcion(Inscripciones inscripcion) {
        String query = "INSERT INTO inscripciones_eventos (id_evento, id_usuario, fecha_inscripcion) " +
                "VALUES (?, ?, ?)";
        String fechaActual = LocalDate.now().toString();
        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, inscripcion.getId_evento());
            stmt.setInt(2, inscripcion.getId_usuario());
            stmt.setTimestamp(3, inscripcion.getFecha_inscripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Inscripciones> listarInscripcionesPorEvento(int idEvento) {
        List<Inscripciones> lista = new ArrayList<>();
        String sql = "SELECT i.id_evento, i.id_usuario, i.fecha_inscripcion, i.asistio, u.nombre_completo " +
                "FROM inscripciones_eventos i " +
                "JOIN usuarios u ON i.id_usuario = u.id_usuario " +
                "WHERE i.id_evento = ?";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idEvento);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Inscripciones insc = new Inscripciones();
                insc.setId_evento(rs.getInt("id_evento"));
                insc.setId_usuario(rs.getInt("id_usuario"));
                insc.setFecha_inscripcion(rs.getTimestamp("fecha_inscripcion"));
                insc.setAsistencia(rs.getBoolean("asistio"));
                insc.setNombreUsuario(rs.getString("nombre_completo")); // Nuevo campo

                lista.add(insc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public boolean existeInscripcion(int idUsuario, int idEvento) {
        // Consulta SQL que cuenta cuántos registros existen con ese usuario y evento
        String query = "SELECT COUNT(*) FROM inscripciones_eventos WHERE id_usuario = ? AND id_evento = ?";

        // Bloque try-with-resources que asegura que la conexión, statement y resultset se cierren automáticamente
        try (Connection con = conexionBD.getConexion();             // Abre conexión a la base de datos
             PreparedStatement stmt = con.prepareStatement(query)) { // Prepara la consulta parametrizada

            // Establece los valores de los parámetros en el query
            stmt.setInt(1, idUsuario); // Primer "?" será reemplazado por idUsuario
            stmt.setInt(2, idEvento);  // Segundo "?" será reemplazado por idEvento

            // Ejecuta la consulta y obtiene el resultado
            ResultSet rs = stmt.executeQuery();

            // Si hay un resultado (siempre habrá uno con COUNT), lo evalúa
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si el conteo es mayor a 0, ya existe la inscripción
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error si ocurre una excepción con la BD
        }

        // Si ocurre un error o no hay resultados, devuelve false por defecto
        return false;
    }

    @Override
    public void eliminarInscripcion(int idUsuario, int idEvento) {
        String sql = "DELETE FROM inscripciones_eventos WHERE id_usuario = ? AND id_evento = ?";
        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idEvento);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
