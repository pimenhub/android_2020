package com.example.myapp_9;

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

        getSupportActionBar().setTitle("nombre");
        lista = findViewById(R.id.listaMeses);

        //Declaracion de los items de la lista
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

        num.add(1);
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


        //Declaracion del adaptador para la visualizacion de la lista
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datos);
        //lista.setAdapter(adapter);

        //metodo para utilizar el evento de click en cada item de la lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "A pulsado " + datos.get(position) , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MesesActivity.class);
                intent.putExtra("dato", datos.get(position));
                intent.putExtra("numero", num.get(position));
                startActivity(intent);
            }
        });

        MiAdaptador miAdaptador = new MiAdaptador(this, R.layout.lista_personalizada, datos);
        lista.setAdapter(miAdaptador);



    }

}
