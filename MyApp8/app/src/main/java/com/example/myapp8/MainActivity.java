package com.example.myapp8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campo1;
    private String anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        campo1 = findViewById(R.id.txtAnio);


    }

    public void onClick(View view) {

        anio = campo1.getText().toString();

        if(!anio.isEmpty()){
            Intent intent = new Intent(this, ReceptorActivity.class);
            intent.putExtra("an", anio);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Dato no Ingresado", Toast.LENGTH_SHORT).show();
        }


    }
}
