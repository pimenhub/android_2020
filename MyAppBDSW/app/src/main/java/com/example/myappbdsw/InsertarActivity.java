package com.example.myappbdsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class InsertarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    public static final String IP_SERVER ="http://192.168.0.15/";

    private EditText txt1, txt2, txt3, txt4;

    //realizan la conexion directa con el SW --php--
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        txt1 = findViewById(R.id.txtNomMedi);
        txt2 = findViewById(R.id.txtCantidad);
        txt3 = findViewById(R.id.txtPrecio);
        txt4 = findViewById(R.id.txtFechaV);

        requestQueue = Volley.newRequestQueue(this);


    }

    public void onClick(View view) {
        this.insertarSW();
    }

    public void insertarSW(){
        String url;
        if(!txt1.getText().toString().isEmpty()&&!txt2.getText().toString().isEmpty()&&!txt3.getText().toString().isEmpty()&&
                !txt4.getText().toString().isEmpty()){
            try {
                url = this.IP_SERVER+"php_sw/insertar_sw.php?nombre_medicamento="+txt1.getText().toString()+
                "&cantidad="+txt2.getText().toString()+"&precio="+txt3.getText().toString()+"&fecha_vencimiento="+txt4.getText().toString();

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
}
