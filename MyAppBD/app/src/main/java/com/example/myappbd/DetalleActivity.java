package com.example.myappbd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class DetalleActivity extends AppCompatActivity {
    private Fragment f1;
    private String id, marca, nombre, sabor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        f1 = new ReceptorFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorF,f1).commit();
        this.recibirDatos();
        this.datosParaFragments();

    }


    public void recibirDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        marca = bundle.getString("marca");
        nombre = bundle.getString("nombre");
        sabor = bundle.getString("sabor");
    }

    public void datosParaFragments(){
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("marca",marca);
        bundle.putString("nombre",nombre);
        bundle.putString("sabor",sabor);

        f1.setArguments(bundle);
    }
}
