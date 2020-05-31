package com.example.myapp11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptadorRecycler extends RecyclerView.Adapter<MiAdaptadorRecycler.ViewHolder> {

    ArrayList<String> lista = new ArrayList<>();

    public MiAdaptadorRecycler(ArrayList<String> lista){
        this.lista = lista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.datos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView campo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            campo = itemView.findViewById(R.id.txtTexto);
        }
        public void datos(String d){
            campo.setText(d);
        }
    }
}
