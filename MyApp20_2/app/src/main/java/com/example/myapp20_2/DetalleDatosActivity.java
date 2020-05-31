package com.example.myapp20_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class DetalleDatosActivity extends AppCompatActivity {

    private Fragment f1;

    private String id, nom, sab, tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_datos);
        f1 = new ReceptorFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorF,f1).commit();

        this.recibirDatos();
        this.datosParaFragment();

    }

    public void recibirDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nom = bundle.getString("nombre");
        sab = bundle.getString("sabor");
        tipo = bundle.getString("tipo");
    }
    public void datosParaFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("nombre", nom);
        bundle.putString("sabor", sab);
        bundle.putString("tipo", tipo);
        f1.setArguments(bundle);
    }
}
