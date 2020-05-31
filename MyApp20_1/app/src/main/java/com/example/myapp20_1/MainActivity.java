package com.example.myapp20_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText n, e, f;
    TextView d1, d2, d3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.nombre);
        e = findViewById(R.id.edad);
        f = findViewById(R.id.fruta);
        d1 = findViewById(R.id.dato1);
        d2 = findViewById(R.id.dato2);
        d3 = findViewById(R.id.dato3);

        this.cargarPreferencias();

    }

    public void onClick(View view) {
        this.guardarPreferencias();
    }

    //Se necesitan dos metodos, uno para guardar y otro para cargar las preferencias

    public void guardarPreferencias(){
        //creamos la preferencia y definimos el nombre y la privacidad
        SharedPreferences sharedPreferences = getSharedPreferences("infoP",
                Context.MODE_PRIVATE);
        String nom, fruta;
        int edad;
        nom = n.getText().toString();
        edad = Integer.parseInt(e.getText().toString());
        fruta = f.getText().toString();
        //editamos el archivo creado con la informacion de las preferencias
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nombre", nom);
        editor.putInt("edad", edad);
        editor.putString("fruta", fruta);
        d1.setText(nom);
        d2.setText(String.valueOf(edad));
        d3.setText(fruta);
        editor.commit();

    }

    public void cargarPreferencias(){
        SharedPreferences sharedPreferences = getSharedPreferences("infoP",
                Context.MODE_PRIVATE);
        String nom, fruta;
        int edad;
        nom = sharedPreferences.getString("nombre", "-");
        edad = sharedPreferences.getInt("edad",0);
        fruta = sharedPreferences.getString("fruta", "-");

        d1.setText(nom);
        d2.setText(String.valueOf(edad));
        d3.setText(fruta);
    }





}
