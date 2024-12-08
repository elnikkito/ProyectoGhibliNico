package com.example.proyectoghibli.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.proyectoghibli.R;
import com.example.proyectoghibli.model.Pelicula;
import com.example.proyectoghibli.view.InfoPeliculas;
import java.util.List;

public class AdaptadorPeliculasPorDirector extends RecyclerView.Adapter<AdaptadorPeliculasPorDirector.PeliculaViewHolder> {

    private List<Pelicula> peliculas;
    private Context context;

    public AdaptadorPeliculasPorDirector(List<Pelicula> peliculas, Context context) {
        this.peliculas = peliculas;
        this.context = context;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_pelicula, parent, false);
        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titulo.setText(pelicula.getTitle());
        Glide.with(context).load(pelicula.getImage()).into(holder.imagen);

        holder.imagen.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoPeliculas.class);
            intent.putExtra("TITULO", pelicula.getTitle());
            intent.putExtra("DESCRIPCION", pelicula.getDescription());
            intent.putExtra("DIRECTOR", pelicula.getDirector());
            intent.putExtra("PRODUCTOR", pelicula.getProducer());
            intent.putExtra("FECHA", pelicula.getRelease_date());
            intent.putExtra("DURACION", pelicula.getRunning_time());
            intent.putExtra("BANNER", pelicula.getMovie_banner());

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imagen;

        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            imagen = itemView.findViewById(R.id.imagePelicula);
        }
    }
}




