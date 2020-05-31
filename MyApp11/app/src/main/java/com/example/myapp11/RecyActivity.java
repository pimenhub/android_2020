package com.example.myapp11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private ArrayList<String> info = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);

        recycler = findViewById(R.id.recyclerId);
        //el plus del recycler
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recycler.setLayoutManager(new GridLayoutManager(this, 3));

        for (int i = 0; i <=30; i++){
            info.add("Restaurante No. "+i);
        }

        MiAdaptadorRecycler miAdaptadorRecycler = new MiAdaptadorRecycler(info);
        recycler.setAdapter(miAdaptadorRecycler);
    }

}
