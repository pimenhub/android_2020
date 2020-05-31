package com.example.myappbd.modeloVO;

public class Bebida {

    private int id;
    private String nombre;
    private String sabor;
    private String marca;

    public Bebida(){

    }

    public Bebida(int id, String nombre, String sabor, String marca) {
        this.id = id;
        this.nombre = nombre;
        this.sabor = sabor;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
