package com.example.myappbdsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
import org.json.JSONObject;

import java.util.ArrayList;

public class EliminarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private EditText txtB;
    private TextView txt1, txt2, txt3, txt4;

    ArrayList<Medicamento> listaMedicamento;
    ArrayList<String> listaDatos;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        txtB = findViewById(R.id.txtIdEliminar);
        txt1 = findViewById(R.id.txtNomMedi);
        txt2 = findViewById(R.id.txtCantidad);
        txt3 = findViewById(R.id.txtPrecio);
        txt4 = findViewById(R.id.txtFechaV);

        requestQueue = Volley.newRequestQueue(this);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarE:
                this.buscarInfo();
                break;
            case R.id.btnEliminarMedicamento:
                this.eliminarSW();
                break;
        }
    }

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
    public void eliminarSW(){
        String url;
        if(!txtB.getText().toString().isEmpty()) {
            try {
                url = InsertarActivity.IP_SERVER + "php_sw/eliminar_sw.php?id=" + txtB.getText().toString();
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
                requestQueue.add(jsonObjectRequest);
                System.err.println("---------------------"+url);
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

        Medicamento medicamento = null;
        //Obtencion de la respuesta de los registros obtenidos por la consulta en el PHP
        JSONArray jsonArray = response.optJSONArray("tbl_medicamento");
        listaMedicamento = new ArrayList<>();
        try {
            for(int i = 0; i < jsonArray.length(); i++){
                medicamento = new Medicamento();
                //se define para poder cargar la informacion ya en el arreglo de respuesta
                JSONObject jsonObject = null;
                //se le asigna cada informacion por recorrido del array de respuesta
                jsonObject = jsonArray.getJSONObject(i);

                //se agrega cada registro relaciono con los campos
                medicamento.setId(jsonObject.optInt("id"));
                medicamento.setNombre_medicamento(jsonObject.optString("nombre_medicamento"));
                medicamento.setCantidad(jsonObject.optInt("cantidad"));
                medicamento.setPrecio(jsonObject.optDouble("precio"));
                medicamento.setFecha_vencimiento(jsonObject.optString("fecha_vencimiento"));

                //llenamos nuestra lista
                listaMedicamento.add(medicamento);
            }
            listaDatos = new ArrayList<>();
            for (int i = 0; i <listaMedicamento.size(); i++){
                listaDatos.add(listaMedicamento.get(i).getNombre_medicamento());

            }
            txt1.setText(medicamento.getNombre_medicamento().toString());



        }

        catch (Exception e){
            Toast.makeText(this, "Error Desconocido ****************"+e, Toast.LENGTH_SHORT).show();
            System.err.println(e);
        }






    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }




}
