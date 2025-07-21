package com.example.Integrador_web.Model;

public class Eventos {
    private int id_evento;
    private int id_creador;
    private String nombre_evento;
    private String fecha;
    private String hora;
    private String ubicacion;
    private String link_ubicacion;
    private String descripcion;
    private String fecha_creacion;
    private String empresa;
    private String tipoincentivo;
    private String condiciones;
    private String restricciones;
    private int cantidad;


    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoincentivo() {
        return tipoincentivo;
    }

    public void setTipoincentivo(String tipoincentivo) {
        this.tipoincentivo = tipoincentivo;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Eventos() {
    }

    public Eventos(int id_evento, int id_creador, String nombre_evento, String fecha, String hora, String ubicacion, String link_ubicacion, String descripcion, String fecha_creacion, String empresa) {
        this.id_evento = id_evento;
        this.id_creador = id_creador;
        this.nombre_evento = nombre_evento;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.link_ubicacion = link_ubicacion;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.empresa = empresa;
    }

    public String getLink_ubicacion() {
        return link_ubicacion;
    }

    public void setLink_ubicacion(String link_ubicacion) {
        this.link_ubicacion = link_ubicacion;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_creador() {
        return id_creador;
    }

    public void setId_creador(int id_creador) {
        this.id_creador = id_creador;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
