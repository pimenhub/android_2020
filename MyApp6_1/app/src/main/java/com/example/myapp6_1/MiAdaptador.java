package com.example.myapp6_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {

    private Context context;//Es donde se obtiene la informacion del entorno, para poder cargar el adaptador
    private int referenciaLayout;
    private ArrayList<String> meses;
    private ArrayList<Integer> num;
    //Se debe de crear un constructor, para agregar los datos
    public MiAdaptador (Context context, int referenciaLayout, ArrayList<String> meses, ArrayList<Integer> num){
        this.context = context;
        this.referenciaLayout = referenciaLayout;
        this.meses = meses;
        this.num = num;

    }

    @Override
    //Es para poder generar el numero de elementos que se van a representar en la lista
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

        String mes = this.meses.get(position);
        int numero = this.num.get(position);

        TextView campo1, campo2;
        campo1 = v.findViewById(R.id.txtLista);
        campo2 = v.findViewById(R.id.txtListaN);
        campo1.setText(mes);
        campo2.setText("mes "+numero);


        return v;
    }
}
