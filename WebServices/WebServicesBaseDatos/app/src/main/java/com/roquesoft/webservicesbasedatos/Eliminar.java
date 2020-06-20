package com.roquesoft.webservicesbasedatos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.roquesoft.webservicesbasedatos.Constante.VariableConstante;


import org.json.JSONObject;

public class Eliminar implements Response.Listener<JSONObject>, Response.ErrorListener {

    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue requestQueue;
    private int id_extraido;
    private Context context;



    public void eliminarPrueba(Context context, int id_extraido) {

        this.id_extraido = id_extraido;
        this.context = context;
        try {


            String url = VariableConstante.IP_SERVER + "trabajos/eliminar_sw.php?id=" +id_extraido;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e){
            Toast.makeText(context, "Ha ocurrido un error "+e, Toast.LENGTH_SHORT).show();
            System.out.println("----------------------" +e);
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(context, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();
        System.out.println("---------------- eliminado correctamente" + response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(context, "Error / "+error, Toast.LENGTH_SHORT).show();
        System.out.println("---------------- Error/ " + error);
    }


}
