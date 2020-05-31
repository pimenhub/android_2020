package com.example.myapp_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {

    private Context context;
    private int referenciaLayout;
    private ArrayList<String> meses = new ArrayList<>();


    public MiAdaptador(Context context, int referenciaLayout, ArrayList<String> meses){

        this.context = context;
        this.referenciaLayout = referenciaLayout;
        this.meses = meses;

    }

    @Override
    public int getCount() {
        return this.meses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.lista_personalizada,null);

        String mes;
        mes = this.meses.get(position);

        TextView campo1;

        campo1 = v.findViewById(R.id.txtTexto);

        campo1.setText(mes);

        return v;
    }
}
