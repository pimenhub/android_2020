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

public class EliminarActivity extends AppCompatActivity {
    private EditText cId;
    private TextView cMarca, cNombre, cSabor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        cId = findViewById(R.id.IngresarIdE);
        cMarca = findViewById(R.id.txtDato1E);
        cNombre = findViewById(R.id.txtDato2E);
        cSabor = findViewById(R.id.txtDato3E);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarE:
                this.buscarDato();
                break;
            case R.id.btnEliminarDato:
                this.eliminarDato();
                break;
            default:
                Toast.makeText(this, "Boton Erroneo", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void buscarDato(){
        if (!cId.getText().toString().isEmpty()){
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD,null,1);
            SQLiteDatabase db = con.getReadableDatabase();
            String[] parametroID = {cId.getText().toString()};
            try {
                Cursor cursor = db.rawQuery("SELECT "+Constantes.CAMPO_MARCA+", "+Constantes.CAMPO_NOMBRE+", "+
                        Constantes.CAMPO_SABOR+ " FROM "+Constantes.TABLA_BEBIDA+" WHERE "+Constantes.CAMPO_ID+"=?",parametroID);
                cursor.moveToFirst();
                cMarca.setText(cursor.getString(0));
                cNombre.setText(cursor.getString(1));
                cSabor.setText(cursor.getString(2));
            }
            catch (Exception e){
                Toast.makeText(this, "Datos no Existentes", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarDato(){
        if(!cId.getText().toString().isEmpty()){
            ConectorSQLiteHelper con = new ConectorSQLiteHelper(this,Constantes.NOMBRE_BD,null,1);
            SQLiteDatabase db  = con.getWritableDatabase();
            try {
                String eliminar;
                eliminar = "DELETE FROM "+Constantes.TABLA_BEBIDA+" WHERE "+Constantes.CAMPO_ID+
                        "= "+cId.getText().toString();
                db.execSQL(eliminar);
                db.close();
                cId.setText("");
                cMarca.setText("");
                cNombre.setText("");
                cSabor.setText("");

                Toast.makeText(this, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(this, "Dato no Encontrado", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Dato no Ingresado", Toast.LENGTH_SHORT).show();
        }
    }

}
