package com.example.myapp10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridLista;
    ArrayList<String> vocales = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Vocales");

        gridLista = findViewById(R.id.gridViewId);

        vocales.add("a");
        vocales.add("e");
        vocales.add("i");
        vocales.add("o");
        vocales.add("u");
        vocales.add("a");
        vocales.add("e");
        vocales.add("i");
        vocales.add("o");
        vocales.add("u");
        vocales.add("a");
        vocales.add("e");
        vocales.add("i");
        vocales.add("o");
        vocales.add("u");



        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vocales);
        //gridLista.setAdapter(adapter);

        gridLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "A pulsado la vocal "+vocales.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        MiAdaptador miAdaptador = new MiAdaptador(this,R.layout.grid_item,vocales);
        gridLista.setAdapter(miAdaptador);

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
                Toast.makeText(this, "Todo se borrarara", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "A pulsado el item 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "A pulsado el item 3", Toast.LENGTH_SHORT).show();
                break;

        }



        return super.onOptionsItemSelected(item);
    }
}
