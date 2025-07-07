package com.example.Integrador_web.Model;

public class Recompensa {
    private int id_recompensa;
    private int id_usuario;
    private int id_empresa;
    private String nombre;
    private String fecha_venc;

    public Recompensa() {
    }

    public Recompensa(int id_usuario, int id_empresa, String nombre, String fecha_venc) {
        this.id_usuario = id_usuario;
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        this.fecha_venc = fecha_venc;
    }

    public int getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(int id_recompensa) {
        this.id_recompensa = id_recompensa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_venc() {
        return fecha_venc;
    }

    public void setFecha_venc(String fecha_venc) {
        this.fecha_venc = fecha_venc;
    }
}
