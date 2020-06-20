package com.roquesoft.webservicesbasedatos.DatosVO;

public class Medicamento {
    private int id, cantidad, id_buscado;
    private String nombre_medicadmento, fecha_vencimiento;
    private double precio;

    public Medicamento(){

    }

    public Medicamento(int id, int cantidad, int id_buscado, String nombre_medicadmento, String fecha_vencimiento, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.id_buscado = id_buscado;
        this.nombre_medicadmento = nombre_medicadmento;
        this.fecha_vencimiento = fecha_vencimiento;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_buscado() {
        System.out.println("---------------- DVO GET "+id_buscado);
        return id_buscado;
    }

    public void setId_buscado(int id_buscado) {
        System.out.println("---------------- DVO SET "+id_buscado);
        this.id_buscado = id_buscado;
    }

    public String getNombre_medicadmento() {
        return nombre_medicadmento;
    }

    public void setNombre_medicadmento(String nombre_medicadmento) {
        this.nombre_medicadmento = nombre_medicadmento;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

