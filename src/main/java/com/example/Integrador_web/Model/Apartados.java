package com.example.Integrador_web.Model;

public class Apartados {
    private int id_apartado;
    private String tituloB;
    private String contenidoB;
    private String rutaB;
    private String tituloA;
    private String contenidoA;
    private String rutaA;
    private String tituloV;
    private String contenidoV;
    private String rutaV;

    public Apartados() {
    }

    public Apartados(int id_apartado, String tituloB, String contenidoB, String rutaB) {
        this.id_apartado = id_apartado;
        this.tituloB = tituloB;
        this.contenidoB = contenidoB;
        this.rutaB = rutaB;
    }

    public String getTituloA() {
        return tituloA;
    }

    public void setTituloA(String tituloA) {
        this.tituloA = tituloA;
    }

    public String getContenidoA() {
        return contenidoA;
    }

    public void setContenidoA(String contenidoA) {
        this.contenidoA = contenidoA;
    }

    public String getRutaA() {
        return rutaA;
    }

    public void setRutaA(String rutaA) {
        this.rutaA = rutaA;
    }

    public String getTituloV() {
        return tituloV;
    }

    public void setTituloV(String tituloV) {
        this.tituloV = tituloV;
    }

    public String getContenidoV() {
        return contenidoV;
    }

    public void setContenidoV(String contenidoV) {
        this.contenidoV = contenidoV;
    }

    public String getRutaV() {
        return rutaV;
    }

    public void setRutaV(String rutaBV) {
        this.rutaV = rutaV;
    }

    public int getId_apartado() {
        return id_apartado;
    }

    public void setId_apartado(int id_apartado) {
        this.id_apartado = id_apartado;
    }

    public String getTituloB() {
        return tituloB;
    }

    public void setTituloB(String tituloB) {
        this.tituloB = tituloB;
    }

    public String getContenidoB() {
        return contenidoB;
    }

    public void setContenidoB(String contenidoB) {
        this.contenidoB = contenidoB;
    }

    public String getRutaB() {
        return rutaB;
    }

    public void setRutaB(String rutaB) {
        this.rutaB = rutaB;
    }
}
