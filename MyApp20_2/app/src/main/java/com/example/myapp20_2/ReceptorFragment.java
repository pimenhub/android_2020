package com.example.myapp20_2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceptorFragment extends Fragment {
    private TextView d1, d2, d3, d4;
    private String id, nom, sab, tipo;
    public ReceptorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getString("id");
        nom = getArguments().getString("nombre");
        sab = getArguments().getString("sabor");
        tipo = getArguments().getString("tipo");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receptor, container, false);

        d1 = v.findViewById(R.id.txtD1);
        d2 = v.findViewById(R.id.txtD2);
        d3 = v.findViewById(R.id.txtD3);
        d4 = v.findViewById(R.id.txtD4);

        d1.setText(id);
        d2.setText(nom);
        d3.setText(sab);
        d4.setText(tipo);

        return v;
    }
}
