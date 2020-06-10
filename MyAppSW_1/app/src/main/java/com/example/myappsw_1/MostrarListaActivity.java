package com.example.myappsw_1;

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
import com.example.myappsw_1.modeloVO.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private ListView lista;
    ArrayList<String> listaDatos;
    ArrayList<Usuario> listaUsuario;

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);


        lista = findViewById(R.id.listaMostrar);
        requestQueue = Volley.newRequestQueue(this);
        this.consultaCompleta();

    }




    public void consultaCompleta(){
        String url;
        url = "http://192.168.0.15/php-1/swM.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onResponse(JSONObject response) {
        Usuario usuario = null;
        JSONArray jsonArray = response.optJSONArray("tbl_usuario");
        listaUsuario = new ArrayList<Usuario>();
        try {
            for (int i=0; i < jsonArray.length(); i++){
                usuario = new Usuario();
                JSONObject jsonObject = null;

                jsonObject = jsonArray.getJSONObject(i);
                usuario.setId(jsonObject.optInt("id"));
                usuario.setNombreUsuario(jsonObject.optString("nombre_usuario"));
                usuario.setNombre(jsonObject.optString("nombre"));
                usuario.setApellido(jsonObject.optString("apellido"));
                usuario.setEdad(jsonObject.optInt("edad"));
                listaUsuario.add(usuario);
            }

            listaDatos = new ArrayList<>();
            for (int i =0; i < listaUsuario.size(); i++){
                listaDatos.add(listaUsuario.get(i).getNombreUsuario());
            }
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaDatos);
            lista.setAdapter(adapter);

        }
        catch (Exception e){
            Toast.makeText(this, "Error Desconocido"+e, Toast.LENGTH_SHORT).show();
            System.err.println(e);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Consulta no realizada Error "+error, Toast.LENGTH_SHORT).show();
    }

}
