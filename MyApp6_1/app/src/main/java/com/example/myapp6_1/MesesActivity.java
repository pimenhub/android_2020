package com.example.myapp6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MesesActivity extends AppCompatActivity {
    TextView campo, campoN;
    ImageView vista;
    String mes;
    int numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meses);

        campo = findViewById(R.id.txtNombreC);
        campoN = findViewById(R.id.txtNum);
        vista = findViewById(R.id.imgVista);
        this.meses();
    }
    private void meses(){
        Bundle bundle = getIntent().getExtras();
        mes = bundle.getString("dato");
        numero = bundle.getInt("numero");

        if(mes.equals("Enero")) {
            campo.setText(mes);
            //campoN.setText("Mes no. " + numero);
            vista.setImageResource(numero);
        }
        else {
            Toast.makeText(this, "Prueba para mes no seleccionado", Toast.LENGTH_SHORT).show();
        }
    }

}
