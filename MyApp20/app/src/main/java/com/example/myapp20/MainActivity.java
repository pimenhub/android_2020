package com.example.myapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtN, txtE;
    private TextView dato1, dato2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtN = findViewById(R.id.txtNombre);
        txtE = findViewById(R.id.txtEdad);
        dato1 = findViewById(R.id.info1);
        dato2 = findViewById(R.id.info2);

        this.obtenerPreferencia();

    }

    public void onClick(View view) {
        this.guardarPreferencia();
    }

    //metodo para guardar la informacion
    public void guardarPreferencia(){

        if (!txtN.getText().toString().isEmpty() && !txtE.getText().toString().isEmpty()) {
            //creacion de archivo para almacenar la informacion
            SharedPreferences preferencias = getSharedPreferences("archivoShared", Context.MODE_PRIVATE);
            String nombre;
            int edad;

            nombre = txtN.getText().toString();
            edad = Integer.parseInt(txtE.getText().toString());

            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("nom", nombre);
            editor.putInt("ed", edad);

            dato1.setText(nombre);
            dato2.setText(String.valueOf(edad));

            editor.commit();
        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }


    }
    //Metodo para obtener la preferencia
    public void obtenerPreferencia(){
        SharedPreferences preferences = getSharedPreferences("archivoShared", Context.MODE_PRIVATE);

        String nombre;
        int edad;

        nombre = preferences.getString("nom", "-");
        edad = preferences.getInt("ed", 0);

        dato1.setText(nombre);
        dato2.setText(String.valueOf(edad));
    }


}
