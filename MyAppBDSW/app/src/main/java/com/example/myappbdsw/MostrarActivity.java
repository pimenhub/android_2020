package com.example.myappbdsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class MostrarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private ListView lista;
    private ArrayList<String> listaDatos;
    private ArrayList<Medicamento> listaMedicamento;

    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        lista = findViewById(R.id.listaMostrar);
        requestQueue = Volley.newRequestQueue(this);

        this.consultaCompletaSW();
    }

    public void consultaCompletaSW(){
        String url;
        url = InsertarActivity.IP_SERVER+"/php_sw/mostrar_sw.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        requestQueue.add(jsonObjectRequest);
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
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            lista.setAdapter(adapter);
        }

        catch (Exception e){
            Toast.makeText(this, "Error Desconocido "+e, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error "+error, Toast.LENGTH_SHORT).show();
    }
}
