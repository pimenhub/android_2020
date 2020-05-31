package com.example.myapp_cine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReciboActivity extends AppCompatActivity {
    private EditText campoN, campoA, campoC, campoNi;
    private TextView precioB, totalB;
    private String cN, cA, cC, cNi, tB;
    private int pB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);

        campoN = findViewById(R.id.nombreP);
        campoA = findViewById(R.id.apellidoP);
        campoC = findViewById(R.id.cantidadB);
        campoNi = findViewById(R.id.nitP);
        precioB = findViewById(R.id.textoPrecio);
        totalB = findViewById(R.id.textoTotal);

        this.completo();
    }

    public void onClick(View view) {
        if(!campoN.getText().toString().isEmpty()&&!campoA.getText().toString().isEmpty()&&!campoC.getText().toString().isEmpty()&&!campoNi.getText().toString().isEmpty()){

            Toast.makeText(this, "Gracias por su compra "+campoN.getText()+" "+campoA.getText(), Toast.LENGTH_SHORT).show();


        }
        else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void completo(){
        Bundle bundle = getIntent().getExtras();
        pB = bundle.getInt("precioBoleto");
        precioB.setText(String.valueOf(pB));

        campoC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!campoC.getText().toString().isEmpty()) {
                    tB = campoC.getText().toString();
                    int d;
                    d = Integer.parseInt(tB);
                    String sumaTotal = s.toString();
                    int multi;
                    multi = pB * d;

                    sumaTotal = String.valueOf(multi);

                    totalB.setText(sumaTotal);
                }
                else {
                    totalB.setText("TOTAL");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
