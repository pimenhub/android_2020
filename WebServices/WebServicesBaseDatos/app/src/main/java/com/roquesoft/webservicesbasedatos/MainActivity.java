package com.roquesoft.webservicesbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextActivity (View view){
        switch (view.getId()){
            case R.id.insertar:
                Intent insertar = new Intent (this, Insertar.class);
                startActivity(insertar);
                break;
            case R.id.mostrar:
                Intent mostrar = new Intent(this, Mostrar.class);
                startActivity(mostrar);
                break;
            case R.id.eliminar:
                Intent eliminar = new Intent(this, ConsultaId.class);
                startActivity(eliminar);
                break;

            default:
                break;
        }

    }
}