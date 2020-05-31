package com.example.myapp20_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp20_2.constantes.Constantes;

public class MostrarActivity extends AppCompatActivity {
    private EditText campoIngreso;
    private TextView textoN, textoS, textoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        campoIngreso = findViewById(R.id.txtIngresarId);
        textoN = findViewById(R.id.recepNombre);
        textoS = findViewById(R.id.recepSabor);
        textoT = findViewById(R.id.recepTipo);

    }

    public void onClick(View view) {
        this.consultarDato();
    }

    public void consultarDato(){
        ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,"helados_bd",null,1);
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametroId = {campoIngreso.getText().toString()};

        if (!campoIngreso.getText().toString().isEmpty()) {
            try {
                //declarmos el objeto Cursor, que es un coleccion de filas
                //donde se de debe de conocer las columnas y el tipo
                Cursor cursor = db.rawQuery("SELECT " + Constantes.CAMPO_NOMBRE + ", " +
                        Constantes.CAMPO_SABOR + ", " + Constantes.CAMPO_TIPO_HELADO +
                        " FROM " + Constantes.TABLA_HELADO + " WHERE " + Constantes.CAMPO_ID + "=? ", parametroId);

                cursor.moveToFirst();
                textoN.setText(cursor.getString(0));
                textoS.setText(cursor.getString(1));
                textoT.setText(cursor.getString(2));
                cursor.close();
            } catch (Exception e) {
                Toast.makeText(this, "Datos No encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Datos No ingresados", Toast.LENGTH_SHORT).show();
        }





    }
}
