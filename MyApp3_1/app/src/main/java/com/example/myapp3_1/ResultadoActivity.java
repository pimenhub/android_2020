package com.example.myapp3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {
    TextView texto;
    String n, p, c, m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        texto = findViewById(R.id.txtResultadoA3);
        this.calcular();
    }




    private void calcular() {
        //Intent intento = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            n = bundle.getString("nombre");
            p = bundle.getString("precio");
            c = bundle.getString("cantidad");
            m = bundle.getString("marca");
            double iva = 0.12;
            int precio = Integer.parseInt(p);
            double valorConIva = precio + iva;
            int cant = Integer.parseInt(c);
            double total = valorConIva * cant;

            texto.setText("El Total a pagar es " + total+" de la compra de "+n+" de la marca "+m);
        }
    }

}
