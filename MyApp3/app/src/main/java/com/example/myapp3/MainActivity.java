package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText campoTexto;
    TextView mostrarTexto;

    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = findViewById(R.id.txtCampo);
        mostrarTexto = findViewById(R.id.txtMostrar);

    }
    private void dato(){
        //int e = Integer.parseInt(campoTexto.getText().toString());
        nombre = campoTexto.getText().toString();

        mostrarTexto.setText("Mi nombre es "+nombre);

    }
    private void ocultarTeclado(){
        View v = this.getCurrentFocus();
        if(v != null){
            InputMethodManager met = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            met.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }

    public void onclick(View view) {
        if (view.getId() == R.id.btnValidar){
            this.dato();
            this.ocultarTeclado();
        }
    }
}
