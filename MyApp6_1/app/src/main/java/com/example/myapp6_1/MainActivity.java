package com.example.myapp6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    ArrayList<String> datos = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaEjemplo);

        //Datos a mostrar

        datos.add("Enero");
        datos.add("Febrero");
        datos.add("Marzo");
        datos.add("Abril");
        datos.add("Mayo");
        datos.add("Junio");
        datos.add("Julio");
        datos.add("Agosto");
        datos.add("Septiembre");
        datos.add("Octubre");
        datos.add("Noviembre");
        datos.add("Diciembre");

        num.add(R.drawable.news);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        num.add(8);
        num.add(9);
        num.add(10);
        num.add(11);
        num.add(12);


        //ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1, datos);
        //lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "A pulsado: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                if(position == 0) {
                    Intent intent = new Intent(getApplicationContext(), MesesActivity.class);
                    intent.putExtra("dato", datos.get(position));
                    intent.putExtra("numero", num.get(position));
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "No existe actividad para este ITEM", Toast.LENGTH_SHORT).show();
                }
            }
        });

        MiAdaptador miAdaptador = new MiAdaptador(this, R.layout.lista_personalizada, datos, num);
        lista.setAdapter(miAdaptador);
    }
}
