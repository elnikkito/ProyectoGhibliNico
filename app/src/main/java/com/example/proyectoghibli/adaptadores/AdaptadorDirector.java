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
import com.example.proyectoghibli.view.PeliculasPorDirector;

import java.util.List;

public class AdaptadorDirector extends RecyclerView.Adapter<AdaptadorDirector.DirectorViewHolder> {

    private List<String> directores;
    private Context context;

    public AdaptadorDirector(List<String> directores, Context context) {
        this.directores = directores;
        this.context = context;
    }

    @NonNull
    @Override
    public DirectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_director, parent, false);
        return new DirectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorViewHolder holder, int position) {
        String nombreDirector = directores.get(position);
        holder.nombreDirector.setText(nombreDirector);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PeliculasPorDirector.class);
            intent.putExtra("nombre_director", nombreDirector);  // Pasar el nombre del director
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return directores.size();
    }

    public static class DirectorViewHolder extends RecyclerView.ViewHolder {
        TextView nombreDirector;

        public DirectorViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreDirector = itemView.findViewById(R.id.nombreDirector);
        }
    }
}