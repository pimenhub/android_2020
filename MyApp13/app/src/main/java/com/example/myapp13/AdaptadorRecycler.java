package com.example.myapp13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    ArrayList<DatosVo> listaDatos = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVo> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personalizado, null, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
            holder.campo1.setText(listaDatos.get(position).getNombre());
            holder.campo2.setText(listaDatos.get(position).getDesc());
            holder.img.setImageResource(listaDatos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return this.listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView campo1, campo2;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

         campo1 = itemView.findViewById(R.id.NombreC);
         campo2 = itemView.findViewById(R.id.DesC);
         img = itemView.findViewById(R.id.imgContacto);


        }
    }
}
