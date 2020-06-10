package com.example.myappsw_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class InsertarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private EditText txt1, txt2, txt3, txt4;

    //conexion directa con sw
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        txt1 = findViewById(R.id.txtNomU);
        txt2 = findViewById(R.id.txtNom);
        txt3 = findViewById(R.id.txtApe);
        txt4 = findViewById(R.id.txtEdad);
        requestQueue = Volley.newRequestQueue(this);

    }

    public void onClick(View view) {
        this.conectarConSW();
    }

    public void conectarConSW() {
        String url;
        if (!txt1.getText().toString().isEmpty() && !txt2.getText().toString().isEmpty() &&
                !txt3.getText().toString().isEmpty() && !txt4.getText().toString().isEmpty()) {
            url = "http://192.168.0.15/php-1/sw.php?nombre_usuario=" + txt1.getText().toString() +
                    "&nombre=" + txt2.getText().toString() + "&apellido=" + txt3.getText().toString() +
                    "&edad=" + txt4.getText().toString();
            url = url.replace(" ", "%20");

            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);
        }
        else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos agregados Correctamente", Toast.LENGTH_SHORT).show();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error "+error, Toast.LENGTH_SHORT).show();
    }


}
