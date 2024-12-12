package com.example.proyectoghibli.view.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoghibli.R;
import com.example.proyectoghibli.adaptadores.AdaptadorPersonaje;
import com.example.proyectoghibli.model.Personaje;
import com.example.proyectoghibli.viewmodel.PersonajesViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Nav personaje.
 */
public class nav_personaje extends Fragment {

    private RecyclerView recyclerPersonajes;
    private AdaptadorPersonaje adaptadorPersonaje;
    private List<Personaje> listaPersonajes = new ArrayList<>();
    private PersonajesViewModel personajesViewModel;
    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_personajes, container, false);

        //inicializamos el recyclerView y el shearchView
        recyclerPersonajes = view.findViewById(R.id.recyclerPersonajes);
        searchView = view.findViewById(R.id.searchView);

        recyclerPersonajes.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //inicializamos el viewModel
        personajesViewModel = new ViewModelProvider(this).get(PersonajesViewModel.class);

        //obtenermos los personajes y los observamos con el .observe
        personajesViewModel.obtenerPersonajes().observe(getViewLifecycleOwner(), personajes -> {
            listaPersonajes = personajes;
            adaptadorPersonaje = new AdaptadorPersonaje(getContext(), listaPersonajes);
            recyclerPersonajes.setAdapter(adaptadorPersonaje);
        });

        //metodo para cargar los personakes desde la api
        personajesViewModel.cargarPersonajes();

        //listener para el searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String intro) {
                filtrarPersonajes(intro);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrarPersonajes(newText);
                return false;
            }
        });

        return view;
    }

    //metodo para filtrar los personajes segun lo que introduzca
    private void filtrarPersonajes(String intro) {
        List<Personaje> personajesFiltrados = personajesViewModel.filtrarPersonajes(listaPersonajes, intro);
        adaptadorPersonaje.actualizarLista(personajesFiltrados);
    }
}
