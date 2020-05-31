package com.example.myapp5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText campo1, campo2;
    String nombre, edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 = findViewById(R.id.txtNombre);
        campo2 = findViewById(R.id.txtEdad);
    }
    private void validar(){
        nombre = campo1.getText().toString();
        edad = campo2.getText().toString();
        int ed = Integer.parseInt(edad);

        if(ed >= 18 ){
            Intent mostrar = new Intent(this,MayorActivity.class);
            startActivity(mostrar);
        }
        else {
            Intent mostrar = new Intent(this,MenorActivity.class);
            startActivity(mostrar);
        }
    }



    public void onClickA1(View view) {
        if (!campo1.getText().toString().isEmpty()|| !campo2.getText().toString().isEmpty()){
            this.validar();
        }
        else {

            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
}
