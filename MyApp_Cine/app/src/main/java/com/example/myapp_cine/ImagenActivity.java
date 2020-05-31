package com.example.myapp_cine;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImagenActivity extends Activity {
    private ImageView imgFull;
    private int imagenF;
    private ImageButton imgS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        imgFull = findViewById(R.id.imgFull);
        imgS = findViewById(R.id.imgSalir);

        this.receptorImagenFull();
    }

    public void receptorImagenFull(){
        Bundle bundle = getIntent().getExtras();
        imagenF = bundle.getInt("imgF");

        imgFull.setImageResource(imagenF);
    }

    public void onClick(View view) {
        finish();
    }
}
