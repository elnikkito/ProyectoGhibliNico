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
import com.example.proyectoghibli.view.activitys.InfoPeliculas;
import java.util.List;

/**
 * Adaptador peliculas por director.
 */
public class AdaptadorPeliculasPorDirector extends RecyclerView.Adapter<AdaptadorPeliculasPorDirector.PeliculaViewHolder> {

    private List<Pelicula> peliculas;
    private Context context;

    /**
     *
     * @param peliculas the peliculas
     * @param context   the context
     */
    public AdaptadorPeliculasPorDirector(List<Pelicula> peliculas, Context context) {
        this.peliculas = peliculas;
        this.context = context;
    }

    //aqui controlamos la creacion de cada viewHolder para cada elemento del recyclerview
    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_pelicula, parent, false);
        return new PeliculaViewHolder(view);
    }

    //datos que seran representados en cada vista
    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titulo.setText(pelicula.getTitle());
        Glide.with(context).load(pelicula.getImage()).into(holder.imagen);

        //configuramos el onClicl para que al pulsar sobre la imagen nos mande
        //a la clase InfoPeliculas donde estan los datos de cada pelicula
        holder.imagen.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoPeliculas.class);
            intent.putExtra("titulo", pelicula.getTitle());
            intent.putExtra("descripcion", pelicula.getDescription());
            intent.putExtra("director", pelicula.getDirector());
            intent.putExtra("productor", pelicula.getProducer());
            intent.putExtra("fecha", pelicula.getRelease_date());
            intent.putExtra("duracion", pelicula.getRunning_time());
            intent.putExtra("banner", pelicula.getMovie_banner());

            context.startActivity(intent);
        });

    }

    //contador de la cantidad de elementos que teiene la lista
    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    //asiganmos los datos del xml con los que queremos mostrar
    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Titulo.
         */
        TextView titulo;
        /**
         * The Imagen.
         */
        ImageView imagen;

        /**
         *
         * @param itemView the item view
         */
        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            imagen = itemView.findViewById(R.id.imagePelicula);
        }
    }
}




