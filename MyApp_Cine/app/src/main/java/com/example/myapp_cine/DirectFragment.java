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
public class DirectFragment extends Fragment {
    private TextView textoD, textoA;
    private String directoresF, actoresF;

    public DirectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        directoresF = getArguments().getString("directores");
        actoresF = getArguments().getString("actores");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_direct, container, false);
        textoD = v.findViewById(R.id.txtDirectores);
        textoA = v.findViewById(R.id.txtActores);

        textoD.setText(directoresF);
        textoA.setText(actoresF);
        return v;
    }
}
