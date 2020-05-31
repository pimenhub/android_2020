package com.example.myapp7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ReceptorActivity extends AppCompatActivity {
    private TextView campoN, campoA, campoE, campoT, campoD;
    private String nombre, apellido, edad, telefono, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

        campoN = findViewById(R.id.txtNombreA2);
        campoA = findViewById(R.id.txtApellidoA2);
        campoE = findViewById(R.id.txtEdadA2);
        campoT = findViewById(R.id.txtTelefonoA2);
        campoD = findViewById(R.id.txtDireccionA2);

        this.obtener();

    }

    private void obtener(){

        nombre = campoN.getText().toString();
        apellido = campoA.getText().toString();
        edad = campoE.getText().toString();
        telefono = campoT.getText().toString();
        direccion = campoD.getText().toString();

        //Agregar Bundle, que me permite traer los datos de otra actividad
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            nombre = bundle.getString("nom");
            apellido = bundle.getString("ape");
            edad = bundle.getString("ed");
            telefono = bundle.getString("tel");
            direccion = bundle.getString("dir");


            campoN.setText("Nombre: "+nombre);
            campoA.setText("Apellido: "+apellido);
            campoE.setText("Edad: "+edad);
            campoT.setText("Telefono: "+telefono);
            campoD.setText("Direccion: "+direccion);
        }
        else{
            Toast.makeText(this, "Datos no validos", Toast.LENGTH_SHORT).show();
        }


    }


}
