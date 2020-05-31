package com.example.myapp_cine;

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
public class PuntuaFragment extends Fragment {
    TextView textoP, textoR;
    private String puntua, recauda;

    public PuntuaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        puntua = getArguments().getString("puntuacion");
        recauda = getArguments().getString("recaudacion");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_puntua, container, false);

        textoP = v.findViewById(R.id.txtPuntua);
        textoR = v.findViewById(R.id.txtRecauda);

        textoP.setText(puntua);
        textoR.setText(recauda);

        return v;
    }
}
