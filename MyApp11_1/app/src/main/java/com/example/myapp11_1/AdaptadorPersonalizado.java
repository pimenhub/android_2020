package com.example.myapp11_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {

    ArrayList<DatosVo> listaDatos = new ArrayList<>();
    public AdaptadorPersonalizado(ArrayList<DatosVo> listaDatos){
        this.listaDatos = listaDatos;
    }


    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personalizado, null, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {
        holder.campo1.setText(listaDatos.get(position).getNombre());
        holder.campo2.setText(listaDatos.get(position).getDes());
        holder.img.setImageResource(listaDatos.get(position).getImagne());
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
            campo1 = itemView.findViewById(R.id.txtNombre);
            campo2 = itemView.findViewById(R.id.txtDes);
            img = itemView.findViewById(R.id.imgId);
        }
    }
}
