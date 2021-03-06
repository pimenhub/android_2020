package com.example.myapp9_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> vocales;

    public MiAdaptador(Context context, int layout, ArrayList<String> vocales){
        this.context = context;
        this.layout = layout;
        this.vocales = vocales;
    }


    @Override
    public int getCount() {
        return this.vocales.size();
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
        v = layoutInflater.inflate(R.layout.personalizado,null);
        String vo =this.vocales.get(position);
        TextView textView;
        textView = v.findViewById(R.id.txtGrid);

        textView.setText(vo);
        return v;
    }
}
