package com.example.pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etqNumero;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etqNumero = findViewById(R.id.etqNumero);
    }

    public void pulsar(View view) {

        if(view.getId() == R.id.btnMas){

            mas();
        }
        if(view.getId() == R.id.btnMenos){

            menos();
        }
    }


    private void mas(){
       contador++;
        etqNumero.setText(contador+"");
    }
    private void menos(){
        contador--;
        etqNumero.setText(contador+"");
    }

}
