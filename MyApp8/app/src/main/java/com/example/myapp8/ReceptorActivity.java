package com.example.myapp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReceptorActivity extends AppCompatActivity {
    private TextView campoA, campoB, campoM, campoS, campoD;
    private String anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

        campoA = findViewById(R.id.txtAnioA2);
        campoB = findViewById(R.id.txtBisiestoA2);
        campoM = findViewById(R.id.txtMesA2);
        campoS = findViewById(R.id.txtSemanaA2);
        campoD = findViewById(R.id.txtDiasA2);


        this.datos();

    }

    private void datos(){

        anio = campoA.getText().toString();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            anio = bundle.getString("an");
            campoA.setText("El año "+anio);

            int anioNumero = Integer.parseInt(anio);

            GregorianCalendar calendar = new GregorianCalendar();

            if(calendar.isLeapYear(anioNumero)){
                campoB.setText("Es Bisiesto");
                campoM.setText("Tiene 12 meses");
                campoS.setText("Tiene 52 semanas + 1 día");
                campoD.setText("Tiene 366 días");
            }
            else {
                campoB.setText("No es Bisiesto");
                campoM.setText("Tiene 12 meses");
                campoS.setText("Tiene 52");
                campoD.setText("Tiene 365 días");
            }

        }
        else {
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }
    }


}
