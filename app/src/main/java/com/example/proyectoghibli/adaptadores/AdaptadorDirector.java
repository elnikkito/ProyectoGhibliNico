package com.example.proyectoghibli.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectoghibli.R;
import com.example.proyectoghibli.view.activitys.PeliculasPorDirector;

import java.util.List;

/**
 *  Adaptador director.
 */
public class AdaptadorDirector extends RecyclerView.Adapter<AdaptadorDirector.DirectorViewHolder> {

    private List<String> directores;
    private Context context;

    /**
     *
     * @param directores the directores
     * @param context    the context
     */
    public AdaptadorDirector(List<String> directores, Context context) {
        this.directores = directores;
        this.context = context;
    }

    //aqui controlamos la creacion de cada viewHolder para cada elemento del recyclerview
    @NonNull
    @Override
    public DirectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_director, parent, false);
        return new DirectorViewHolder(view);
    }

    //metodo de como va estar representado visualmente
    @Override
    public void onBindViewHolder(@NonNull DirectorViewHolder holder, int position) {
        String nombreDirector = directores.get(position);
        holder.nombreDirector.setText(nombreDirector);

        //configuramos el onclick para que al pulsar sobre el nombre nos redireccioanra a la sigueinte clase
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PeliculasPorDirector.class);
            intent.putExtra("nombre_director", nombreDirector);
            context.startActivity(intent);
        });
    }

    //contador de la cantidad de elementos que tiene la lista
    @Override
    public int getItemCount() {
        return directores.size();
    }

    /**
     *  Director view holder.
     */
    //asiganmos los valores del xml con los que queremos mostrar
    public static class DirectorViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Nombre director.
         */
        TextView nombreDirector;

        /**
         *
         * @param itemView the item view
         */
        public DirectorViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreDirector = itemView.findViewById(R.id.nombreDirector);
        }
    }
}