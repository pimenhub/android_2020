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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EliminarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private EditText txtB;
    private TextView txt1, txt2, txt3, txt4;

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    JSONArray jsonArray;
    JSONObject jsonObject;
    Eliminar eliminar = new Eliminar();
    int datoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        txtB = findViewById(R.id.txtIdEliminar);
        txt1 = findViewById(R.id.nombreME);
        txt2 = findViewById(R.id.cantidadE);
        txt3 = findViewById(R.id.precioE);
        txt4 = findViewById(R.id.fechaVE);

        requestQueue = Volley.newRequestQueue(this);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarE:
                if(!txtB.getText().toString().isEmpty()) {
                    this.buscarInfo();
                }
                else {
                    Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnEliminarMedicamento:
                if(!txtB.getText().toString().isEmpty()&& !txt1.getText().toString().equals("...")) {
                    eliminar.eliminarClase(getApplicationContext(), Integer.parseInt(txtB.getText().toString()));
                    txtB.setText("");
                    txt1.setText("...");
                    txt2.setText("...");
                    txt3.setText("...");
                    txt4.setText("...");
                }
                else {
                    Toast.makeText(this, "Datos No Ingresados", Toast.LENGTH_SHORT).show();
                }
                    break;
        }
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
