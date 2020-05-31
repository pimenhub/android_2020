package com.example.myapp20_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp20_2.constantes.Constantes;

public class ActualizarActivity extends AppCompatActivity {
    private EditText cId, cNom, cSab, cTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        cId = findViewById(R.id.txtInsertarIdA);
        cNom = findViewById(R.id.txtCA1);
        cSab = findViewById(R.id.txtCA2);
        cTipo = findViewById(R.id.txtCA3);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarA:
                this.buscarDato();
                break;
            case R.id.btnActualizar:
                this.actualizarDato();
                break;
        }
    }

    public void buscarDato(){
        if (!cId.getText().toString().isEmpty()){
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,Constantes.NOMBRE_BD,null,1);
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

    public void actualizarDato(){
        if (!cId.getText().toString().isEmpty()&&!cNom.getText().toString().isEmpty()
                &&!cSab.getText().toString().isEmpty()&&!cTipo.getText().toString().isEmpty()) {
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD, null, 1);
            SQLiteDatabase db = con.getWritableDatabase();
            try {
                String actualizar;
                actualizar = "UPDATE " + Constantes.TABLA_HELADO + " SET " + Constantes.CAMPO_NOMBRE + "= '" + cNom.getText().toString() +
                        "', " + Constantes.CAMPO_SABOR + "= '" + cSab.getText().toString() + "', " + Constantes.CAMPO_TIPO_HELADO + "= '" +
                        cTipo.getText().toString() + "' WHERE " + Constantes.CAMPO_ID + "= " + cId.getText().toString() + ";";

                db.execSQL(actualizar);
                db.close();

                cNom.setText("");
                cSab.setText("");
                cTipo.setText("");
                Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Datos No Encotrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Dato No Ingresado", Toast.LENGTH_SHORT).show();
        }


    }
}
