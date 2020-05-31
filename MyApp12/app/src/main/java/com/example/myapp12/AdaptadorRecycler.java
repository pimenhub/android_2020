package com.example.myapp12;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {
    //Crear la lista que va a contener los item y su constructor

    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflamos el nuevo layout personalizado
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        //Comporbar el tama;o de el arraylist
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Agregar los componentes del layout personalizado

        public ViewHolder(@NonNull View itemView) {
            super(itemView);



        }
    }
}
