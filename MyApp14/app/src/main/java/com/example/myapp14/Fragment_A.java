package com.example.myapp14;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_A extends Fragment {

    public Fragment_A() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__a, container, false);

        Button btn;
        btn = v.findViewById(R.id.btnAceptar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = "Guatemala";
                TextView texto;
                texto = getActivity().findViewById(R.id.txtReceptor);
                texto.setText(dato.toString());
            }
        });
        return v;
    }
}
