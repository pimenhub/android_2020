package com.example.myapp20_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapp20_2.constantes.Constantes;
import com.example.myapp20_2.tablasBD.Helado;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity {
    private ListView lista;
    ArrayList<String> listaDatos = new ArrayList<>();
    ArrayList<Helado> listaHelados = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        lista = findViewById(R.id.listaMostrar);

        this.consultarInformacion();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String numId = "Id: "+listaHelados.get(position).getId();
                String nombre = "Nombre: "+listaHelados.get(position).getNombre();
                String sabor = "Sabor: "+listaHelados.get(position).getSabor();
                String tipo = "Tipo Helado: "+listaHelados.get(position).getTipoHelado();


                Intent intent = new Intent(getApplicationContext(), DetalleDatosActivity.class);
                intent.putExtra("id",numId);
                intent.putExtra("nombre",nombre);
                intent.putExtra("sabor",sabor);
                intent.putExtra("tipo",tipo);
                startActivity(intent);
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaDatos);
        lista.setAdapter(adapter);




    }

    //Se realiza la consulta de los datos correspondientes a la informacion que
    //existe en la base de datso
    public void consultarInformacion(){
        ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,"helados_bd",null,1);
        SQLiteDatabase db = con.getReadableDatabase();
        Helado helado=null;
        listaHelados=new ArrayList<Helado>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Constantes.TABLA_HELADO, null);

        while (cursor.moveToNext()){
            helado = new Helado();
            helado.setId(cursor.getInt(0));
            helado.setNombre(cursor.getString(1));
            helado.setSabor(cursor.getString(2));
            helado.setTipoHelado(cursor.getString(3));

            listaHelados.add(helado);

        }
        //llenamos la listview con los parametros que queremos
        listaDatos = new ArrayList<String>();
        for (int i = 0; i<listaHelados.size(); i++){
            listaDatos.add(listaHelados.get(i).getNombre());
        }

    }
}
