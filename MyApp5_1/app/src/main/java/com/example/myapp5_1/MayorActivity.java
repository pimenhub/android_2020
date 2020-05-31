package com.example.myapp5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MayorActivity extends AppCompatActivity {
    TextView num1, num2, mostrar;
    EditText resultado;
    String resultadoF;
    int vA1, vA2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayor);

        num1 = findViewById(R.id.txtN1);
        num2 = findViewById(R.id.txtN2);
        mostrar = findViewById(R.id.txtMostrar);
        resultado = findViewById(R.id.txtResultado);

        vA1 = (int) Math.floor(Math.random()*(10-0+1)+0);
        vA2 = (int) Math.floor(Math.random()*(10-0+1)+0);

        num1.setText(String.valueOf(vA1));
        num2.setText(String.valueOf(vA2));
    }
    private void operacion(){
        resultadoF = resultado.getText().toString();
        int respuesta = vA1*vA2;
        int respuestaF = Integer.parseInt(resultadoF);

       if (respuesta == respuestaF){
            mostrar.setText("La respuesta es "+respuestaF+"\n"+"Excelente, ya eres todo un hombre");
        }
        else {
            Toast.makeText(this, "No es correcto, vuelve a intentar", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickA3(View view) {

            switch (view.getId()) {
                case R.id.btnMul:
                    if (!resultado.getText().toString().isEmpty()) {
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
