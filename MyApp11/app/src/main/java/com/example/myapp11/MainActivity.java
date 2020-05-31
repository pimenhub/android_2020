package com.example.myapp11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageView imagen;

    private TextView textoH1, textoH2, textoB1, textoB2, textoP1, textoP2;

    private String nombreH;
    private String precioH;
    private String nombreB;
    private String precioB;
    private String nombreP;
    private String precioP;

    private int i1;
    private int i2;
    private int i3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Restaurante");

        imagen = findViewById(R.id.imgItem);

        textoH1 = findViewById(R.id.nombre1);
        textoH2 = findViewById(R.id.precio1);
        textoB1 = findViewById(R.id.nombre2);
        textoB2 = findViewById(R.id.precio2);
        textoP1 = findViewById(R.id.nombre3);
        textoP2 = findViewById(R.id.precio3);

        nombreH = textoH1.getText().toString();
        nombreB = textoB1.getText().toString();
        nombreP = textoP1.getText().toString();
        precioH = textoH2.getText().toString();
        precioB = textoB2.getText().toString();
        precioP = textoP2.getText().toString();

        nombreH = "Quesoburguesadoble";
        precioH = "Q. 35";
        i1 = R.drawable.ff1;
        nombreB = "5 capas";
        precioB = "Q. 20";
        i2 = R.drawable.ff2;
        nombreP = "Super Krispy";
        precioP = "Q. 45";
        i3 = R.drawable.ff3;



        textoH1.setText(nombreH);
        textoH2.setText(precioH);
        textoB1.setText(nombreB);
        textoB2.setText(precioB);
        textoP1.setText(nombreP);
        textoP2.setText(precioP);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton1:
                Intent intent = new Intent(this,ReceptorActivity.class);
                intent.putExtra("nombre", nombreH);
                intent.putExtra("precio", precioH);
                intent.putExtra("img", i1);
                startActivity(intent);
                break;
            case R.id.boton2:
                Intent intent2 = new Intent(this,ReceptorActivity.class);
                intent2.putExtra("nombre", nombreB);
                intent2.putExtra("precio", precioB);
                intent2.putExtra("img", i2);
                startActivity(intent2);
                break;
            case R.id.boton3:
                Intent intent3 = new Intent(this,ReceptorActivity.class);
                intent3.putExtra("nombre", nombreP);
                intent3.putExtra("precio", precioP);
                intent3.putExtra("img", i3);
                startActivity(intent3);
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                imagen.setImageResource(this.i1);
                break;
            case R.id.item2:
                imagen.setImageResource(this.i2);
                break;
            case R.id.item3:
                imagen.setImageResource(this.i3);
                break;
            case R.id.item4:
                Intent intent = new Intent(this, RecyActivity.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
