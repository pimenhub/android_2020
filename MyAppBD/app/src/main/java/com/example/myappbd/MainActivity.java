package com.example.myappbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myappbd.constantes.Constantes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Implementar la clase conector para realizar la conexion
        ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD,null,1);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertar:
                Intent intent = new Intent(this,InsertarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrar:
                Intent intent1 = new Intent(this,MostrarActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnMostrarLista:
                Intent intent2 = new Intent(this,MostrarListaActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnActualizar:
                Intent intent3 = new Intent(this,ActualizarActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnEliminar:
                Intent intent4 = new Intent(this,EliminarActivity.class);
                startActivity(intent4);
                break;

            default:
                Toast.makeText(this, "Error en la Aplicacion", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
