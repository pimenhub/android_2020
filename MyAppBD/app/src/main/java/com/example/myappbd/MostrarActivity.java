package com.example.myappbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappbd.constantes.Constantes;

public class MostrarActivity extends AppCompatActivity {
    private EditText campoIngreso;
    private TextView textoM, textoN, textoS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        campoIngreso = findViewById(R.id.txtInsertarId);
        textoM = findViewById(R.id.txtD1);
        textoN = findViewById(R.id.txtD2);
        textoS = findViewById(R.id.txtD3);

    }

    public void onClick(View view) {
        this.consultaMostrar();
    }

    public void consultaMostrar(){
        if (!campoIngreso.getText().toString().isEmpty()){
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,Constantes.NOMBRE_BD,null,1);
            SQLiteDatabase db = con.getReadableDatabase();
            //Buscar por medio de un parametro, en este caso el ID
            String[] parametroID = {campoIngreso.getText().toString()};
            try {
                //Curso, permite una coleccion de filas, es necesita conocer los atributos y sus tipos
                Cursor cursor = db.rawQuery("SELECT "+ Constantes.CAMPO_MARCA + ", "+Constantes.CAMPO_NOMBRE+
                        ", "+Constantes.CAMPO_SABOR+" FROM "+Constantes.TABLA_BEBIDA+
                        " WHERE "+Constantes.CAMPO_ID + "=?",parametroID);
                cursor.moveToFirst();
                textoM.setText(cursor.getString(0));
                textoN.setText(cursor.getString(1));
                textoS.setText(cursor.getString(2));

                cursor.close();
            }
            catch (Exception e){
                Toast.makeText(this, "Datos No Existente "+e, Toast.LENGTH_SHORT).show();
                System.err.println("Error Latente "+e);
            }
        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

}
