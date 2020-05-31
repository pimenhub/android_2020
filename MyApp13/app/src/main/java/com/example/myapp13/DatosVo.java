package com.example.myapp13;

public class DatosVo {

    private String nombre;
    private String desc;
    private int imagen;

    public DatosVo(){

    }

    public DatosVo(String nombre, String desc, int imagen) {
        this.nombre = nombre;
        this.desc = desc;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
