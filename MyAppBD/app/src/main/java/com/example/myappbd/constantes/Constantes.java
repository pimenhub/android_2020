package com.example.myappbd.constantes;

public class Constantes {

    //creacion de constantes relacionadas con los componentes de BD

    public static final String TABLA_BEBIDA = "bebida";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_MARCA = "marca";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_SABOR = "sabor";
    public static final String NOMBRE_BD = "bebidas_bd";

    public static final String CREAR_TABLA_BEBIDA = "CREATE TABLE "+
            TABLA_BEBIDA+" ("+CAMPO_ID+" INTEGER, "+CAMPO_MARCA+" TEXT, "+
                            CAMPO_NOMBRE+" TEXT, "+CAMPO_SABOR+" TEXT"+ ");";




}
