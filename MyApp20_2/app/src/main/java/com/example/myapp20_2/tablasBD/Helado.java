package com.example.myapp20_2.tablasBD;

public class Helado {

    private int id;
    private String nombre;
    private String sabor;
    private String tipoHelado;

    public Helado(){

    }

    public Helado(int id, String nombre, String sabor, String tipoHelado) {
        this.id = id;
        this.nombre = nombre;
        this.sabor = sabor;
        this.tipoHelado = tipoHelado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTipoHelado() {
        return tipoHelado;
    }

    public void setTipoHelado(String tipoHelado) {
        this.tipoHelado = tipoHelado;
    }
}
