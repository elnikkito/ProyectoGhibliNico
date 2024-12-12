package com.example.proyectoghibli.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectoghibli.R;
import com.example.proyectoghibli.model.Personaje;
import java.util.List;

public class AdaptadorPersonaje extends RecyclerView.Adapter<AdaptadorPersonaje.PersonajeViewHolder> {

    private Context context;
    private List<Personaje> personajes;

    public AdaptadorPersonaje(Context context, List<Personaje> personajes) {
        this.context = context;
        this.personajes = personajes;
    }

    //aqui controlamos la creacion de cada viewHolder para cada elemento del recyclerview
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_personajes, parent, false);
        return new PersonajeViewHolder(view);
    }

    //datos representados en cada vista
    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);

        holder.namePersonaje.setText(personaje.getName());
        holder.genderPersonaje.setText("Genero: " + personaje.getGender());
        holder.agePersonaje.setText("Edad: " + personaje.getAge());
        holder.eyeColorPersonaje.setText("Color Ojos: " + personaje.getEye_color());
        holder.hairColorPersonaje.setText("Color Pelo: " + personaje.getHair_color());
    }

    //caontador de la cantidad de elementos que teiene la lista
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    //metodo para actualizar la lista de personajes
    //sirve para el searchView
    public void actualizarLista(List<Personaje> nuevosPersonajes) {
        this.personajes = nuevosPersonajes;
        notifyDataSetChanged();
    }

    //asiganmos los datos del xml con los que queremos mostrar
    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        TextView namePersonaje, genderPersonaje, agePersonaje, eyeColorPersonaje, hairColorPersonaje;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            namePersonaje = itemView.findViewById(R.id.nombrePersonaje);
            genderPersonaje = itemView.findViewById(R.id.genderPersonaje);
            agePersonaje = itemView.findViewById(R.id.agePersonaje);
            eyeColorPersonaje = itemView.findViewById(R.id.eyeColorPersonaje);
            hairColorPersonaje = itemView.findViewById(R.id.hairColorPersonaje);
        }
    }
}
