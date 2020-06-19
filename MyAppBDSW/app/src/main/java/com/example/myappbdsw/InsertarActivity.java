package com.example.myappbdsw;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import java.util.Calendar;


public class InsertarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    public static final String IP_SERVER ="http://192.168.0.10/";

    private EditText txt1, txt2, txt3, txt4;

    //realizan la conexion directa con el SW --php--
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;




    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    ///Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        txt1 = findViewById(R.id.txtNomMedi);
        txt2 = findViewById(R.id.txtCantidad);
        txt3 = findViewById(R.id.txtPrecio);
        txt4 = findViewById(R.id.txtFechaV);
        txt4.setEnabled(false);


        requestQueue = Volley.newRequestQueue(this);



    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnInsertarMedi:
                this.insertarSW();
                break;
            case R.id.imgFecha:
                //txt4.requestFocus();
                this.fechaCalendario();
                break;
        }
    }

    public void insertarSW(){
        String url;
        if(!txt1.getText().toString().isEmpty()&&!txt2.getText().toString().isEmpty()&&!txt3.getText().toString().isEmpty()&&
                !txt4.getText().toString().isEmpty()){
            try {

                url = this.IP_SERVER+"php_sw/insertar_sw.php?nombre_medicamento="+txt1.getText().toString()+
                "&cantidad="+txt2.getText().toString()+"&precio="+txt3.getText().toString()+"&fecha_vencimiento="+txt4.getText().toString();
                //System.out.println("---------------------------------------------"+url);
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
                requestQueue.add(jsonObjectRequest);
            }
            catch (Exception e){
                Toast.makeText(this, "Error Desconocido", Toast.LENGTH_SHORT).show();
                System.err.println(e.getMessage());
            }
        }
        else {
            Toast.makeText(this, "Error. Datos Faltantes", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(this, "Datos Ingresados Correctamente", Toast.LENGTH_SHORT).show();

        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a "+ error, Toast.LENGTH_SHORT).show();
        System.err.println("------------- "+error);
    }

    public void fechaCalendario(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? 0 + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? 0 + String.valueOf(mesActual):String.valueOf(mesActual);
                //Convertir anio
                String anio = String.valueOf(year);

                //Muestro la fecha con el formato deseado
                txt4.setText(mesFormateado + "/" + diaFormateado + "/" + anio);
                //txt4.setText(diaFormateado + "/" + mesFormateado + "/" + anio);

                //System.out.println("---------------------------"+diaFormateado + "/" + mesFormateado + "/" + anio);
            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();


    }
}
