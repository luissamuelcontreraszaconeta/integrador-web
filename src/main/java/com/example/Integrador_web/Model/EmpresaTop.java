package com.example.Integrador_web.Model;

public class EmpresaTop {

    private int idEmpresa;
    private String nombreEmpresa;
    private int totalKg;

    public EmpresaTop() {
    }

    public EmpresaTop(int idEmpresa, String nombreEmpresa, int totalKg) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.totalKg = totalKg;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTotalKg() {
        return totalKg;
    }

    public void setTotalKg(int totalKg) {
        this.totalKg = totalKg;
    }
}
