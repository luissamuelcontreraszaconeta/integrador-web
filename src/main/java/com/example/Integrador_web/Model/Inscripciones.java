package com.example.Integrador_web.Model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Inscripciones {
    private int id_inscripciones;
    private int id_evento;
    private int id_usuario;
    private Timestamp fecha_inscripcion;
    private boolean asistencia;
    private String nombreUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Inscripciones() {
    }

    public Inscripciones(int id_evento, int id_usuario, Timestamp fecha_inscripcion, boolean asistencia) {
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.fecha_inscripcion = fecha_inscripcion;
        this.asistencia = asistencia;
    }

    public int getId_inscripciones() {
        return id_inscripciones;
    }

    public void setId_inscripciones(int id_inscripciones) {
        this.id_inscripciones = id_inscripciones;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Timestamp getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Timestamp fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
}
