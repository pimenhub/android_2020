package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText campoTexto, campoN1, campoN2;
    TextView mostrar;
    String nombre;
    String d1;
    String d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = findViewById(R.id.txtCampoNombre);
        mostrar = findViewById(R.id.txtMostrar);
        campoN1 = findViewById(R.id.txtCampoN1);
        campoN2 = findViewById(R.id.txtCampoN2);

    }
    private void dato(){
        nombre = campoTexto.getText().toString();
        d1 = campoN1.getText().toString();
        d2 = campoN2.getText().toString();

        if (nombre.isEmpty()||d1.isEmpty()||d2.isEmpty()) {
            Toast.makeText(this, "Datos", Toast.LENGTH_SHORT).show();
            return;}
            Calendar ca = Calendar.getInstance();
            int ann = ca.get(Calendar.YEAR);
            int n1;
            int n2;
            int re;
            n1 = Integer.parseInt(d1);
            n2 = Integer.parseInt(d2);
            re = n1 + n2;
            double po = Math.pow(n1,n2);
            mostrar.setText("Su nombre es: " + "\n" + nombre + "\n" + "La Suma es: " + re
                    + "\n" + "Año Actual " + ann+ "\n" + "Potencia " + po);




    }

    public void pulsar(View view) {
        if(view.getId() == R.id.btnMostrar){
            this.dato();
        }
    }
}
