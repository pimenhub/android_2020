package com.roquesoft.webservicesbasedatos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Informacion extends Fragment {

    private TextView nombre_Medicamento, cantidad_Medicamento, precio_Medicamento, fecha_Vencimiento;
    private String nombreMedicamento, fechaVencimiento;
    private int cantidad;
    private double precio;


    public Informacion() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nombreMedicamento = getArguments().getString("nombre");
        cantidad = getArguments().getInt("cantidad");
        precio = getArguments().getDouble("precio");
        fechaVencimiento = getArguments().getString("vencimiento");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_informacion, container, false);
        nombre_Medicamento = view.findViewById(R.id.frag_Nombre);
        cantidad_Medicamento = view.findViewById(R.id.frag_Cantidad);
        precio_Medicamento = view.findViewById(R.id.frag_Precio);
        fecha_Vencimiento = view.findViewById(R.id.frag_Vencimiento);

        nombre_Medicamento.setText(nombreMedicamento);
        cantidad_Medicamento.setText(String.valueOf(cantidad));
        precio_Medicamento.setText(String.valueOf(precio));
        fecha_Vencimiento.setText(fechaVencimiento);

        return view;
    }
}