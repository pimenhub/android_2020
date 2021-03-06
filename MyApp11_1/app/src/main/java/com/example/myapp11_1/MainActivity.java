package com.example.myapp11_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DatosVo> lista = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.insertarDatos();

        AdaptadorPersonalizado adaptadorPersonalizado = new AdaptadorPersonalizado(lista);
        recyclerView.setAdapter(adaptadorPersonalizado);
    }

    private void insertarDatos(){
        lista.add(new DatosVo("La Hamburguesa", "Excelente Calidad", R.drawable.ff1));
        lista.add(new DatosVo("El Burrito", "Excelente Calidad", R.drawable.ff2));
        lista.add(new DatosVo("El Pollo Frito", "Excelente Calidad", R.drawable.ff3));
        lista.add(new DatosVo("La Hamburguesa", "Excelente Calidad", R.drawable.ff1));
        lista.add(new DatosVo("El Burrito", "Excelente Calidad", R.drawable.ff2));
        lista.add(new DatosVo("El Pollo Frito", "Excelente Calidad", R.drawable.ff3));
        lista.add(new DatosVo("La Hamburguesa", "Excelente Calidad", R.drawable.ff1));
        lista.add(new DatosVo("El Burrito", "Excelente Calidad", R.drawable.ff2));
        lista.add(new DatosVo("El Pollo Frito", "Excelente Calidad", R.drawable.ff3));
        lista.add(new DatosVo("La Hamburguesa", "Excelente Calidad", R.drawable.ff1));
        lista.add(new DatosVo("El Burrito", "Excelente Calidad", R.drawable.ff2));
        lista.add(new DatosVo("El Pollo Frito", "Excelente Calidad", R.drawable.ff3));
    }
}
