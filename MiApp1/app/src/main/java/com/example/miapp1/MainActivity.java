package com.example.miapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaraciones de objetos de van a tener una accion
    TextView txtNumero;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero = findViewById(R.id.txtNumero);
    }

    private void mas(){
        contador++;
        txtNumero.setText(contador+"");

        if(contador == 10){
            Toast.makeText(this, "Excelente usted llego a "+contador, Toast.LENGTH_SHORT).show();

        }
    }
    private  void menos(){
        contador--;
        txtNumero.setText(contador+"");
    }
    

    public void pulsar(View view) {

        if(view.getId() == R.id.btnMas){
            mas();
        }
        if (view.getId() == R.id.btnMenos){
            menos();

        }



    }
}
