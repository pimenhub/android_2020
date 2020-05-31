package com.example.myappbd;

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

    private String id, marc, nom, sab;
    public ReceptorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        id = getArguments().getString("id");
        marc = getArguments().getString("marca");
        nom = getArguments().getString("nombre");
        sab = getArguments().getString("sabor");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receptor, container, false);
        d1 = v.findViewById(R.id.IdF);
        d2 = v.findViewById(R.id.MarcaF);
        d3 = v.findViewById(R.id.NombreF);
        d4 = v.findViewById(R.id.SaborF);

        d1.setText(id);
        d2.setText(marc);
        d3.setText(nom);
        d4.setText(sab);

        return v;
    }
}
