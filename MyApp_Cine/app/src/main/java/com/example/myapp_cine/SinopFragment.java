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
public class SinopFragment extends Fragment {

    private TextView textoS;
    private String sinopsisF;

    public SinopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sinopsisF = getArguments().getString("sinop");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sinop, container, false);

        textoS = v.findViewById(R.id.txtSinop);
        textoS.setText(sinopsisF);

        return v;
    }
}
