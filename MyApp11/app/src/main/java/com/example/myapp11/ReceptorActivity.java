package com.example.myapp11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceptorActivity extends AppCompatActivity {
    private TextView campo1, campo2;
    private String nombre, precio;
    private int img;
    private ImageView imgR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);


        campo1 = findViewById(R.id.textoReceptor1);
        campo2 = findViewById(R.id.textoReceptor2);
        imgR = findViewById(R.id.imgReceptor);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            nombre = bundle.getString("nombre");
            precio = bundle.getString("precio");
            img = bundle.getInt("img");

            campo1.setText(nombre);
            campo2.setText(precio);
            imgR.setImageResource(img);

        }





    }
}
