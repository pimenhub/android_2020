package com.example.myappbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myappbd.constantes.Constantes;
import com.example.myappbd.modeloVO.Bebida;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity {
    private ListView listaM;
    ArrayList<String> listaDatos;
    ArrayList<Bebida> listaBebida;

    private String numId, marc, nom, sab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        listaM = findViewById(R.id.listaMostrar);

        this.consultaCompleta();

        listaM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                numId = String.valueOf(listaBebida.get(position).getId());
                marc = listaBebida.get(position).getMarca();
                nom = listaBebida.get(position).getNombre();
                sab = listaBebida.get(position).getSabor();

                Intent intent = new Intent(getApplicationContext(),DetalleActivity.class);
                intent.putExtra("id",numId);
                intent.putExtra("marca",marc);
                intent.putExtra("nombre", nom);
                intent.putExtra("sabor",sab);
                startActivity(intent);
            }
        });


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listaDatos);
        listaM.setAdapter(adapter);

    }

    public void consultaCompleta(){
        ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,Constantes.NOMBRE_BD,null,1);
        SQLiteDatabase db = con.getReadableDatabase();
        Bebida bebida = null;

        listaBebida = new ArrayList<>();

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM "+ Constantes.TABLA_BEBIDA,null);
            //se llena la lista de tipo clase, con los datos de la base de datos
            while (cursor.moveToNext()){
                bebida = new Bebida();
                bebida.setId(cursor.getInt(0));
                bebida.setMarca(cursor.getString(1));
                bebida.setNombre(cursor.getString(2));
                bebida.setSabor(cursor.getString(3));

                listaBebida.add(bebida);
            }
            //se llena el listview con los datos obtenidos
            listaDatos = new ArrayList<>();
            for (int i =0; i < listaBebida.size(); i++){
                listaDatos.add(listaBebida.get(i).getNombre());
            }
        }
        catch (Exception e){
            Toast.makeText(this, "No existen Datos", Toast.LENGTH_SHORT).show();
        }


    }

}
