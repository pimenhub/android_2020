package com.roquesoft.webservicesbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.roquesoft.webservicesbasedatos.Constante.VariableConstante;
import com.roquesoft.webservicesbasedatos.DatosVO.Medicamento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity implements Response.Listener <JSONObject>, Response.ErrorListener {

    private ListView list_view;
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;

    private ArrayList <String> listaDatos;
    private ArrayList <Medicamento> listaMedicamento;

    private String nombreMedicamento, fechaVencimiento;
    private int cantidad;
    private double precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        list_view =findViewById(R.id.list_View);
        requestQueue = Volley.newRequestQueue(this);

        this.consultarWS();

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nombreMedicamento = listaMedicamento.get(position).getNombre_medicadmento();
                cantidad = listaMedicamento.get(position).getCantidad();
                precio = listaMedicamento.get(position).getPrecio();
                fechaVencimiento = listaMedicamento.get(position).getFecha_vencimiento();

                Intent detalle = new Intent(getApplicationContext(), DetalleMedicamento.class);
                detalle.putExtra("nombre", nombreMedicamento);
                detalle.putExtra("cantidad", cantidad);
                detalle.putExtra("precio", precio);
                detalle.putExtra("vencimiento", fechaVencimiento);
                startActivity(detalle);

            }
        });
    }

    public void consultarWS (){
        String url;
        url = VariableConstante.IP_SERVER+"trabajos/mostrar_sw.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);
    }



    @Override
    public void onResponse(JSONObject response) {

        //obtener respuesta de los registros de la consulta por PHP
        Medicamento medicamento = null;
        JSONArray jsonArray = response.optJSONArray("medicamento");
        listaMedicamento = new ArrayList <>();

        try {
            for(int i = 0; i < jsonArray.length(); i++ ){
                medicamento = new Medicamento();
                //se define para poder cargar la informacion en el arreglo
                JSONObject jsonObject = null;
                //se le asigna la informacion por recorrido
                jsonObject = jsonArray.getJSONObject(i);
                //setteo de los registros
                medicamento.setId(jsonObject.optInt("id"));
                medicamento.setNombre_medicadmento(jsonObject.optString("nombre_medicamento"));
                medicamento.setCantidad(jsonObject.optInt("cantidad"));
                medicamento.setFecha_vencimiento(jsonObject.optString("fecha_vencimiento"));
                medicamento.setPrecio(jsonObject.optDouble("precio"));

                //llenado de lista
                listaMedicamento.add(medicamento);

            }

            listaDatos = new ArrayList<>();
            for (int i = 0; i < listaMedicamento.size(); i++){
                listaDatos.add(listaMedicamento.get(i).getId() +" "+ listaMedicamento.get(i).getNombre_medicadmento());
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            list_view.setAdapter(adapter);

        } catch (Exception e){
            Toast.makeText(this, "Error "+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error "+error, Toast.LENGTH_SHORT).show();
    }
}