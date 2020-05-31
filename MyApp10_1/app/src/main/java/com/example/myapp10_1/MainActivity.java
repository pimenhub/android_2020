package com.example.myapp10_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> lista = new ArrayList<>();
    private RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.idRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setLayoutManager(new GridLayoutManager(this,3));

        for (int i = 0; i <=10; i++){
            lista.add("Item No. "+i);
        }

        MiAdaptadorRecycler miAdaptadorRecycler = new MiAdaptadorRecycler(lista);
        recycler.setAdapter(miAdaptadorRecycler);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton1:
                recycler.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.boton2:
                recycler.setLayoutManager(new GridLayoutManager(this,3));
                break;
        }
    }
}
