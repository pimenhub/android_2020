package com.example.myapp10_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptadorRecycler extends RecyclerView.Adapter<MiAdaptadorRecycler.ViewHolder> {

    //Segundo referenciar una lista
    private ArrayList<String> lista = new ArrayList<>();

    public MiAdaptadorRecycler(ArrayList<String> lista){
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
//primero referenciar los componentes del nuevo layout
    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView campo;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
             campo = itemView.findViewById(R.id.txtTexto);
        }
        //tercero crear un metodo para asignar
        public void asignarDatos(String datos){
        campo.setText(datos);
    }

    }
}
