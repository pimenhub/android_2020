package com.example.myapp5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenorActivity extends AppCompatActivity {
    TextView num1, num2, mostrar;
    EditText campoR;
    String dato1, dato2, resultado, resultadoF;
    int vA1, vA2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menor);

        num1 = findViewById(R.id.txtN1);
        num2 = findViewById(R.id.txtN2);
        campoR = findViewById(R.id.txtResultado);
        mostrar = findViewById(R.id.txtMostrar);

        vA1 = (int) Math.floor(Math.random()*(10-0+1)+0);
        vA2 = (int) Math.floor(Math.random()*(10-0+1)+0);
        num1.setText(vA1+"");
        num2.setText(vA2+"");

    }
    private void operacion(){

        resultado = campoR.getText().toString();
        int correcto = vA1 + vA2;
        int respuesta = Integer.parseInt(resultado);

        if(correcto == respuesta){
            mostrar.setText("La respuesta es "+respuesta+"\n"+"Muy bien ya no eres tan Bebé");
        }
        else {
            Toast.makeText(this, "No es correcto, vuelve a intentar", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickA2(View view) {

            switch (view.getId()) {
                case R.id.btnSuma:
                    if (!campoR.getText().toString().isEmpty()) {
                        this.operacion();
                    }
                    else{
                        Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btnSalir:
                    finish();
                    break;
            }


    }
}
