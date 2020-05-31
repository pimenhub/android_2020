package com.example.myapp3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText c1, c2;
    TextView resultado;
    String nombre;
    String edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1 = findViewById(R.id.txtCampo1);
        c2 = findViewById(R.id.txtCampo2);
        resultado = findViewById(R.id.txtResultado);
    }

    private void dato(){
        nombre = c1.getText().toString();
        edad = c2.getText().toString();

        if (!nombre.isEmpty() || !edad.isEmpty()){
            int ed = Integer.parseInt(edad);
            Calendar c = Calendar.getInstance();
            int a = c.get(Calendar.YEAR);
            int r = a - ed;

            resultado.setText("Su nombre es "+nombre+"\n"+" y su edad es "+r);
        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void ocultarTeclado(){
        View v = this.getCurrentFocus();
        if(v != null){
            InputMethodManager met = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            met.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.btnPulsar:
                this.dato();
                this.ocultarTeclado();
                break;
            case R.id.btnPulsar2:
                Intent intento = new Intent(this, CalculoActivity.class);
                startActivity(intento);
        }
    }
}
