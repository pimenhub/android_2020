package com.example.myapp20_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Debemos de agregar la implementacion del conector
        ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,"helados_bd",null,1);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertar:
                Intent intent = new Intent(getApplicationContext(), InsertarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrar:
                Intent intent1 = new Intent(getApplicationContext(), MostrarActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnMostrarLista:
                Intent intent2 = new Intent(getApplicationContext(), MostrarListaActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnEliminar:
                Intent intent5 = new Intent(getApplicationContext(), EliminarActivity.class);
                startActivity(intent5);
                break;
            case R.id.btnModificar:
                Intent intent4 = new Intent(getApplicationContext(), ActualizarActivity.class);
                startActivity(intent4);
                break;

            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
