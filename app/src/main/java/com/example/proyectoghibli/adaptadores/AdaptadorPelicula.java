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
import com.example.proyectoghibli.view.activitys.InfoPeliculas;
import com.example.proyectoghibli.model.Pelicula;
import com.example.proyectoghibli.R;

import java.util.List;

/**
 * Adaptador pelicula.
 */
public class AdaptadorPelicula extends RecyclerView.Adapter<AdaptadorPelicula.PeliculaViewHolder> {

    private List<Pelicula> peliculas;
    private Context context;

    /**
     *
     * @param peliculas the peliculas
     * @param context   the context
     */
    public AdaptadorPelicula(List<Pelicula> peliculas, Context context) {
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

    //datos representados en cada vista
    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titulo.setText(pelicula.getTitle());

        Glide.with(context)
                .load(pelicula.getImage())
                .into(holder.imagen);

        //configuracmos un onClick para que cuando pulsemos a la imgaen nos mande,
        //a la clase InfoPeliculas mostrando su contenido, con su respectivo xml.
        holder.itemView.setOnClickListener(v -> {
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
