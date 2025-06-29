package com.example.Integrador_web.Model;

public class Foros {
    private int id_tema;
    private String nombre;
    private String descripcion;

    public Foros() {
    }

    public Foros(int id_tema, String nombre, String descripcion) {
        this.id_tema = id_tema;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescipcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
