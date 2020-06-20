package com.roquesoft.webservicesbasedatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class DetalleMedicamento extends AppCompatActivity {
    private Fragment fragmentInformation;

    private String nombreMedicamento, fechaVencimiento;
    private int cantidad;
    private double precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_medicamento);

        fragmentInformation = new Informacion();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_Container, fragmentInformation).commit();

        this.recibirDatos();
        this.datosFrag();
    }

    public void recibirDatos (){
        Bundle bundle = getIntent().getExtras();
        nombreMedicamento = bundle.getString("nombre");
        cantidad = bundle.getInt("cantidad");
        precio = bundle.getDouble("precio");
        fechaVencimiento = bundle.getString("vencimiento");
    }

    public void datosFrag (){
        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombreMedicamento);
        bundle.putInt("cantidad", cantidad);
        bundle.putDouble("precio", precio);
        bundle.putString("vencimiento", fechaVencimiento);

        fragmentInformation.setArguments(bundle);
    }
}