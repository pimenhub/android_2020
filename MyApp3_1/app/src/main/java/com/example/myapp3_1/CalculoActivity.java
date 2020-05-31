package com.example.myapp3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculoActivity extends AppCompatActivity {
    EditText campo1, campo2, campo3, campo4;
    String nombreP, cantidadP, precioP, marcaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        campo1 = findViewById(R.id.txtCampo1A2);
        campo2 = findViewById(R.id.txtCampo2A2);
        campo3 = findViewById(R.id.txtCampo3A2);
        campo4 = findViewById(R.id.txtCampo4A2);
    }


    public void onclick(View view) {

        nombreP = campo1.getText().toString();
        precioP = campo2.getText().toString();
        cantidadP = campo3.getText().toString();
        marcaP = campo4.getText().toString();

        if (!nombreP.isEmpty() || !precioP.isEmpty()|| !cantidadP.isEmpty() || !marcaP.isEmpty()) {

            switch (view.getId()) {
                case R.id.btnPulsarCalcular:
                    Intent intento = new Intent(this, ResultadoActivity.class);
                   intento.putExtra("nombre", nombreP = campo1.getText().toString());
                   intento.putExtra("precio", precioP = campo2.getText().toString());
                   intento.putExtra("cantidad", cantidadP = campo3.getText().toString());
                   intento.putExtra("marca", marcaP);
                    startActivity(intento);
                    break;
            }
        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }
}
