package com.example.myappbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappbd.constantes.Constantes;

public class ActualizarActivity extends AppCompatActivity {
    private EditText cId, cMarca, cNombre, cSabor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        cId = findViewById(R.id.IngresarIdA);
        cMarca = findViewById(R.id.txtDato1A);
        cNombre = findViewById(R.id.txtDato2A);
        cSabor = findViewById(R.id.txtDato3A);

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnBuscarA:
                this.buscarDato();
                break;
            case R.id.btnActualizarDato:
                this.actualizarDatos();
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
                cursor.close();
            }
            catch (Exception e){
                Toast.makeText(this, "Datos no Existentes", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void actualizarDatos(){
        if (!cId.getText().toString().isEmpty()&&!cMarca.getText().toString().isEmpty()&&
                !cNombre.getText().toString().isEmpty()&&!cSabor.getText().toString().isEmpty()){
                ConectorSQLiteHelper con = new ConectorSQLiteHelper(this, Constantes.NOMBRE_BD,null,1);
                SQLiteDatabase db = con.getWritableDatabase();
                try {
                    String actualizar;
                    actualizar = "UPDATE "+Constantes.TABLA_BEBIDA+" SET "+Constantes.CAMPO_MARCA+"= '"+cMarca.getText().toString()+
                            "', "+Constantes.CAMPO_NOMBRE+"= '"+cNombre.getText().toString()+"', "+Constantes.CAMPO_SABOR+
                            "= '"+cSabor.getText().toString()+"' WHERE "+Constantes.CAMPO_ID+"= "+cId.getText().toString()+";";
                    db.execSQL(actualizar);
                    db.close();
                    cMarca.setText("");
                    cNombre.setText("");
                    cSabor.setText("");

                    Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    Toast.makeText(this, "Datos no Encontrados", Toast.LENGTH_SHORT).show();
                }
        }
        else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }


}
