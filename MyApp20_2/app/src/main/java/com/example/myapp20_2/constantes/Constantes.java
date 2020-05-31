package com.example.myapp20_2.constantes;
//En esta clase vamos a elaborar todas las sentencias sql necesarias,
// asingando constantes para ellas

public class Constantes {
//las constantes seran static para poder acceder a ellas sin implementar
    public static final String TABLA_HELADO = "helado";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_SABOR = "sabor";
    public static final String CAMPO_TIPO_HELADO = "tipoHelado";
    public static final String CREAR_TABLA_HELADO="CREATE TABLE "+TABLA_HELADO+" ("+CAMPO_ID+" INTEGER,"+
            CAMPO_NOMBRE+" TEXT,"+CAMPO_SABOR+" TEXT,"+CAMPO_TIPO_HELADO+" TEXT"+");";

    public static final String NOMBRE_BD = "helados_bd";
}
