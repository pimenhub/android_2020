package com.example.myapp_cine;

public class PeliculasVo {
    private String nombre;
    private String duracion;
    private int img;
    private String sinopsis;
    private String directores;
    private String actores;
    private String puntuacion;
    private String recaudacion;


    public PeliculasVo(){

    }
    public PeliculasVo(String nombre, String duracion, int img) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.img = img;
    }
    //Crear variables de datos faltantes, metodos de acceso, constructor especifico de los datos faltantes
    public PeliculasVo(String sinopsis, String directores, String actores, String puntuacion, String recaudacion) {
        this.sinopsis = sinopsis;
        this.directores = directores;
        this.actores = actores;
        this.puntuacion = puntuacion;
        this.recaudacion = recaudacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirectores() {
        return directores;
    }

    public void setDirectores(String directores) {
        this.directores = directores;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(String recaudacion) {
        this.recaudacion = recaudacion;
    }
}
