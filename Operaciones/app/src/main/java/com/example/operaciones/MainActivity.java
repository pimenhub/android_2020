package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText campo1, campo2;
    TextView resultado;

    String n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo1 = findViewById(R.id.txtCampo1);
        campo2 = findViewById(R.id.txtCampo2);
        resultado = findViewById(R.id.txtResultado);

    }

    private void sumar() {

        n1 = campo1.getText().toString();
        n2 = campo2.getText().toString();
        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        } else {
            int d1 = Integer.parseInt(n1);
            int d2 = Integer.parseInt(n2);
            int re = d1 + d2;

            resultado.setText("La suma es " + re);
        }
    }

    private void dividir() {

        n1 = campo1.getText().toString();
        n2 = campo2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        } else {
            int d1 = Integer.parseInt(n1);
            int d2 = Integer.parseInt(n2);
            if (d2 == 0) {
                Toast.makeText(this, "No es posible dividir dentro de cero", Toast.LENGTH_SHORT).show();
            } else {
                int re = d1 / d2;

                resultado.setText("La  division es " + re);
            }
        }
    }


    public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btnSuma:
                    this.sumar();
                    break;
                case R.id.btnDividir:
                    this.dividir();
                    break;


        }
    }

    public void Ocultar(View view) {
        View v = this.getCurrentFocus();
        if(v != null){
            InputMethodManager met = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            met.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }
}
