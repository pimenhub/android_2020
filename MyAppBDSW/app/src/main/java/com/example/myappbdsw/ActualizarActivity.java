package com.example.myappbdsw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myappbdsw.modeloVO.Medicamento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class ActualizarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private EditText txtB, txt1, txt2, txt3, txt4;

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    JSONArray jsonArray;
    JSONObject jsonObject;

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    ///Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        txtB = findViewById(R.id.txtIdEActualizar);
        txt1 = findViewById(R.id.nombreMA);
        txt2 = findViewById(R.id.cantidadA);
        txt3 = findViewById(R.id.precioA);
        txt4 = findViewById(R.id.fechaVA);

        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        txt4.setEnabled(false);

        requestQueue = Volley.newRequestQueue(this);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarA:
                txt1.setEnabled(true);
                txt2.setEnabled(true);
                txt3.setEnabled(true);
                txt4.setEnabled(true);
                this.buscarInfo();
                txtB.setEnabled(false);
                break;

            case R.id.btnActualizarMedicamento:
                txtB.setEnabled(true);

                this.actualizarSW();


                txt1.setEnabled(false);
                txt2.setEnabled(false);
                txt3.setEnabled(false);
                txt4.setEnabled(false);
                break;

            case R.id.btnVolver:
                txtB.setEnabled(true);
                break;
            case R.id.imgFechaA:
                this.fechaCalendario();
                break;
        }
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
    //metodo para buscar por ID
    public void buscarInfo(){
        String url;
        if(!txtB.getText().toString().isEmpty()) {
            try {
                url = InsertarActivity.IP_SERVER + "php_sw/mostrar_id_sw.php?id=" + txtB.getText().toString();
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
                requestQueue.add(jsonObjectRequest);
            }
            catch (Exception e){
                Toast.makeText(this, "Error Desconocido", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    ///Metodo para eliminar el dato encontrado
    public void actualizarSW(){
        String url;
        if(!txtB.getText().toString().isEmpty() && !txt1.getText().toString().equals("")) {
            try {
                url = InsertarActivity.IP_SERVER + "php_sw/actualizar_sw.php?nombre_medicamento="+txt1.getText().toString()
                        +"&cantidad="+txt2.getText().toString()+"&precio="+txt3.getText().toString()+"&fecha_vencimiento="+
                        txt4.getText().toString()+"&id="+txtB.getText().toString();
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,null  ,this);
                requestQueue.add(jsonObjectRequest);
                txtB.setText("");
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(this, "Error Desconocido---------------", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {


        this.respuesta(response);


    }

    public void respuesta(JSONObject respuesta){
        Medicamento medicamento = new Medicamento();
        jsonArray = respuesta.optJSONArray("tbl_medicamento");
        jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(0);
            medicamento.setNombre_medicamento(jsonObject.getString("nombre_medicamento"));
            medicamento.setCantidad(jsonObject.getInt("cantidad"));
            medicamento.setPrecio(jsonObject.getDouble("precio"));
            medicamento.setFecha_vencimiento(jsonObject.getString("fecha_vencimiento"));

        } catch (JSONException e) {
            Toast.makeText(this, "error cath "+e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        txt1.setText(medicamento.getNombre_medicamento());
        txt2.setText(String.valueOf(medicamento.getCantidad()));
        txt3.setText(String.valueOf(medicamento.getPrecio()));
        txt4.setText(medicamento.getFecha_vencimiento());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error Volley "+ error, Toast.LENGTH_SHORT).show();
        System.err.println("------------- "+error);
    }


}
