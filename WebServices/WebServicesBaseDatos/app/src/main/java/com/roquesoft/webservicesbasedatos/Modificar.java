package com.roquesoft.webservicesbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.widget.DatePicker;
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

public class Modificar implements Response.Listener<JSONObject>, Response.ErrorListener {
    private Context context;
    private int id_extraido;

    private String nombreMedicamento, fechaVencimiento;
    private int cantidadMedicamento;
    private double precioMedicamento;

    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue requestQueue;

    public void modificar(Context context, int id_extraido, String nombreMedicamento, int cantidadMedicamento, double precioMedicamento, String fechaVencimiento){
        this.context = context;
        this.id_extraido= id_extraido;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadMedicamento = cantidadMedicamento;
        this.precioMedicamento = precioMedicamento;
        this.fechaVencimiento = fechaVencimiento;

        System.out.println("----------------- "+fechaVencimiento);

        try {
            String url = VariableConstante.IP_SERVER + "trabajos/modificar.php?nombre_medicamento="+nombreMedicamento+"&cantidad="+cantidadMedicamento+"&precio="+precioMedicamento+"&fecha_vencimiento="+fechaVencimiento+"&id="+id_extraido;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "Ha ocurrido un error "+e, Toast.LENGTH_SHORT).show();
            System.out.println("----------------------" +e);
        }

    }



    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(context, "Datos Modificados Correctamente", Toast.LENGTH_SHORT).show();
        System.out.println("---------------- eliminado correctamente" + response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(context, "Error / "+error, Toast.LENGTH_SHORT).show();
        System.out.println("---------------- Error/ " + error);
    }
}