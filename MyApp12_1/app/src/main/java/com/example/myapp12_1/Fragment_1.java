package com.example.myapp12_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_1 extends Fragment {
    Fragment f2;
    public Fragment_1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_1, container, false);

        Button btn;
        btn = v.findViewById(R.id.btnA);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "Hola";
                TextView texto;
                texto = getActivity().findViewById(R.id.Texto);
                texto.setText(info.toString());
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}
