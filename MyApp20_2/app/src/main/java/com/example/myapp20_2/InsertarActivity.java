package com.example.myapp20_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp20_2.constantes.Constantes;

public class InsertarActivity extends AppCompatActivity {
    public EditText campoId, campoNombre, campoSabor, campoTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        campoId = findViewById(R.id.txtId);
        campoNombre = findViewById(R.id.txtNombre);
        campoSabor = findViewById(R.id.txtSabor);
        campoTipo = findViewById(R.id.txtTipo);


    }

    public void onClick(View view) {
        this.insertarHelados();
    }

    public void insertarHelados(){

        if (!campoId.getText().toString().isEmpty()&&!campoNombre.getText().toString().isEmpty()
        &&!campoSabor.getText().toString().isEmpty()&&!campoTipo.getText().toString().isEmpty()) {
            //conectarnos a la base de datos
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, "helados_bd", null, 1);

            //objeto para escribir en la tabla de la base de datos
            SQLiteDatabase db = con.getWritableDatabase();

            //Creamos el query que servira para la insercion
            String insertar;
            insertar = "INSERT INTO " + Constantes.TABLA_HELADO + " (" + Constantes.CAMPO_ID + "," + Constantes.CAMPO_NOMBRE +
                    "," + Constantes.CAMPO_SABOR + "," + Constantes.CAMPO_TIPO_HELADO + ") VALUES (" + campoId.getText().toString() +
                    ",'" + campoNombre.getText().toString() + "','" + campoSabor.getText().toString() +
                    "','" + campoTipo.getText().toString() + "')";

            db.execSQL(insertar);
            db.close();
            campoId.setText("");
            campoNombre.setText("");
            campoSabor.setText("");
            campoTipo.setText("");

            Toast.makeText(this, "Datos Ingresados Correctamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    //crear metodo que va a realizar la insercion de los datos
    public void ingresarDatos(){
        //conectarnos a la base de datos
        ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,"helados_bd",null,1);

        //objeto para escribir en la tabla de la base de datos
        SQLiteDatabase db = con.getWritableDatabase();

        //objeto para poder ingresar los datos
        ContentValues cv = new ContentValues();
        cv.put(Constantes.CAMPO_ID,campoId.getText().toString());
        cv.put(Constantes.CAMPO_NOMBRE,campoNombre.getText().toString());
        cv.put(Constantes.CAMPO_SABOR,campoSabor.getText().toString());
        cv.put(Constantes.CAMPO_TIPO_HELADO,campoTipo.getText().toString());

        Long idDato = db.insert(Constantes.TABLA_HELADO,Constantes.CAMPO_ID,cv);



    }
}
