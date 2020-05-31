package com.example.myapp11_1;

public class DatosVo {

    private String nombre;
    private String des;
    private int imagne;

    public DatosVo(){

    }

    public DatosVo(String nombre, String des, int imagne) {
        this.nombre = nombre;
        this.des = des;
        this.imagne = imagne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImagne() {
        return imagne;
    }

    public void setImagne(int imagne) {
        this.imagne = imagne;
    }
}
