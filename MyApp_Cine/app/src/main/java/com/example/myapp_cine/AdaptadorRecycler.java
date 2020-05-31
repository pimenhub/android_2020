package com.example.myapp_cine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {
    private static ClickListener clickListener;
    ArrayList<PeliculasVo> lista_peliculas = new ArrayList<>();
    public AdaptadorRecycler(ArrayList<PeliculasVo> lista_peliculas){
        this.lista_peliculas = lista_peliculas;
    }



    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,null, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.texto1.setText(lista_peliculas.get(position).getNombre());
        holder.texto2.setText(lista_peliculas.get(position).getDuracion());
        holder.imagen.setImageResource(lista_peliculas.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return this.lista_peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView texto1, texto2;
        public ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Hacer un clic en el recyclerview
            itemView.setOnClickListener(this);
            texto1 = itemView.findViewById(R.id.txt1RId);
            texto2 = itemView.findViewById(R.id.txt2RId);
            imagen = itemView.findViewById(R.id.imgRId);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
    public void setOnItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;
    }
    public interface ClickListener {
        public void onItemClick(int position, View v);
    }
}
