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

public class EliminarActivity extends AppCompatActivity {
    private EditText cId;
    private TextView cNom, cSab, cTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        cId = findViewById(R.id.txtInsertarIdE);
        cNom = findViewById(R.id.txtCE1);
        cSab = findViewById(R.id.txtCE2);
        cTipo = findViewById(R.id.txtCE3);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarE:
                this.buscarDato();
                break;
            case R.id.btnEliminarDato:
                this.eliminarDato();
                break;
        }
    }


    private void buscarDato() {
        if (!cId.getText().toString().isEmpty()){
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD,null,1);
            SQLiteDatabase db = con.getReadableDatabase();
            //Buscar por medio de un parametro, en este caso el ID
            String[] parametroID = {cId.getText().toString()};
            try {
                //Curso, permite una coleccion de filas, es necesita conocer los atributos y sus tipos
                Cursor cursor = db.rawQuery("SELECT "+ Constantes.CAMPO_NOMBRE + ", "+Constantes.CAMPO_SABOR+
                        ", "+Constantes.CAMPO_TIPO_HELADO+" FROM "+Constantes.TABLA_HELADO+
                        " WHERE "+Constantes.CAMPO_ID + "=?",parametroID);
                cursor.moveToFirst();
                cNom.setText(cursor.getString(0));
                cSab.setText(cursor.getString(1));
                cTipo.setText(cursor.getString(2));
                cursor.close();
            }
            catch (Exception e){
                Toast.makeText(this, "Datos No Existente", Toast.LENGTH_SHORT).show();
                System.err.println("Error Latente");
            }
        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void eliminarDato() {
        if (!cId.getText().toString().isEmpty()) {
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD, null, 1);
            SQLiteDatabase db = con.getWritableDatabase();
            try {
                String eliminar;
                eliminar = "DELETE FROM " + Constantes.TABLA_HELADO + " WHERE " + Constantes.CAMPO_ID + "= " + cId.getText().toString();

                db.execSQL(eliminar);
                db.close();

                cId.setText("");
                cNom.setText("");
                cSab.setText("");
                cTipo.setText("");
                Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Dato No Encotrado", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Identificador no Ingresado", Toast.LENGTH_SHORT).show();
        }

    }


}
