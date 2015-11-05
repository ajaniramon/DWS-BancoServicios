package com.fpmislata.banco.business.domain;


public class Provincia {
    int idProvincia;
    String nombre;
    String codigo;

    public Provincia(int idProvincia, String nombre, String codigo) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Provincia(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
}
