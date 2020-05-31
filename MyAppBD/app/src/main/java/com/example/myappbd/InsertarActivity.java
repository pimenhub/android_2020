package com.example.myappbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappbd.constantes.Constantes;

public class InsertarActivity extends AppCompatActivity {

    private EditText campoId, campoMarca, campoNombre, campoSabor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        campoId = findViewById(R.id.txtId);
        campoMarca = findViewById(R.id.txtMarca);
        campoNombre = findViewById(R.id.txtNombre);
        campoSabor = findViewById(R.id.txtSabor);


    }

    public void onClick(View view) {
        this.insertarBebida();
    }


    public void insertarBebida(){
        if (!campoId.getText().toString().isEmpty()&&!campoMarca.getText().toString().isEmpty()
                &&!campoNombre.getText().toString().isEmpty()&&!campoSabor.getText().toString().isEmpty()) {
            //Se realiza la conexion
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD, null, 1);
            //Objeto que me permite escribir en una tabla, insertar los datos
            SQLiteDatabase db = con.getWritableDatabase();

            try {
                String insetar;

                insetar = "INSERT INTO " + Constantes.TABLA_BEBIDA + " (" + Constantes.CAMPO_ID + ", " +
                        Constantes.CAMPO_MARCA + ", " + Constantes.CAMPO_NOMBRE + ", " + Constantes.CAMPO_SABOR +
                        ") VALUES (" + campoId.getText().toString() + ", '" + campoMarca.getText().toString() + "', '" +
                        campoNombre.getText().toString() + "', '" + campoSabor.getText().toString() + "');";
                db.execSQL(insetar);
                db.close();

                campoId.setText("");
                campoMarca.setText("");
                campoNombre.setText("");
                campoSabor.setText("");
            }
            catch (Exception e){
                Toast.makeText(this, "Error "+e, Toast.LENGTH_SHORT).show();
                System.err.println("Error Latente "+e);
            }
        }
        else {
            Toast.makeText(this, "Datos Incompletos", Toast.LENGTH_SHORT).show();
        }


    }




}
