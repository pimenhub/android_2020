package com.example.myapp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campoN, campoA, campoE, campoT, campoD;
    private String nombre, apellido, edad, telefono, direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoN = findViewById(R.id.txtNombre);
        campoA = findViewById(R.id.txtApellido);
        campoE = findViewById(R.id.txtEdad);
        campoT = findViewById(R.id.txtTelefono);
        campoD = findViewById(R.id.txtDireccion);

    }

    private void datos(){

        nombre = campoN.getText().toString();
        apellido = campoA.getText().toString();
        edad = campoE.getText().toString();
        telefono = campoT.getText().toString();
        direccion = campoD.getText().toString();

        if (!nombre.isEmpty()||!apellido.isEmpty()||!edad.isEmpty()||!telefono.isEmpty()||!direccion.isEmpty()){

            Intent intent = new Intent(this,ReceptorActivity.class);

            intent.putExtra("nom", nombre);
            intent.putExtra("ape", apellido);
            intent.putExtra("ed", edad);
            intent.putExtra("tel", telefono);
            intent.putExtra("dir", direccion);

            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }


    }

    public void onClick(View view) {

        this.datos();
    }
}
