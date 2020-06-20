package com.roquesoft.webservicesbasedatos;

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
import com.roquesoft.webservicesbasedatos.Constante.VariableConstante;

import org.json.JSONObject;

import java.util.Calendar;

public class Insertar extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private EditText nombreMedicamento, fechaVencimiento, precio, cantidad;

    public final Calendar c = Calendar.getInstance();

    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int año = c.get(Calendar.YEAR);

    //realiza la conexion directa con el WebService --PHP File--

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        nombreMedicamento = findViewById(R.id.nombreMedicamento);
        fechaVencimiento = findViewById(R.id.fechaVencimiento);
        precio = findViewById(R.id.precio);
        cantidad = findViewById(R.id.cantidad);

        requestQueue = Volley.newRequestQueue(this);

    }

    public void insertar(View view) {
        switch (view.getId()){
            case R.id.insertar:
                consultaInsertar();
                break;
            case R.id.datePicker:
                fechaVencimiento.requestFocus();
                fechaCal();
                break;
            case R.id.fechaVencimiento:
                fechaVencimiento.requestFocus();
                fechaCal();
                break;
            default:
                break;


        }
    }

    public void consultaInsertar() {
        String url;
        if (nombreMedicamento.getText().toString().isEmpty() && fechaVencimiento.getText().toString().isEmpty() &&
                cantidad.getText().toString().isEmpty() && precio.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresar los datos solicitadoa", Toast.LENGTH_SHORT).show();
        } else {

            try {
                url =  VariableConstante.IP_SERVER+"trabajos/insertar_sw.php?nombre_medicamento="+nombreMedicamento.getText().toString()+
                        "&cantidad="+cantidad.getText().toString()+"&precio="+precio.getText().toString()+
                        "&fecha_vencimiento="+fechaVencimiento.getText().toString();

                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
                requestQueue.add(jsonObjectRequest);

            } catch (Exception e) {
                Toast.makeText(this, "Error Desconocido", Toast.LENGTH_SHORT).show();
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();
        nombreMedicamento.setText("");
        fechaVencimiento.setText("");
        cantidad.setText("");
        precio.setText("");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a " + error, Toast.LENGTH_SHORT).show();
        nombreMedicamento.setText("");
        fechaVencimiento.setText("");
        cantidad.setText("");
        precio.setText("");
    }

    public void fechaCal(){
        DatePickerDialog fechaSeleccionada = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int mesActual = month + 1;
                String diaFormato = (dayOfMonth < 10 )? 0 + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormato = (mesActual < 10 )? 0 + String.valueOf(mesActual):String.valueOf(mesActual);
                String añoFormato = String.valueOf(year);
                fechaVencimiento.setText(mesFormato + "/" + diaFormato + "/" + añoFormato);
            }
        }, año, mes, dia);

        fechaSeleccionada.show();
    }
}