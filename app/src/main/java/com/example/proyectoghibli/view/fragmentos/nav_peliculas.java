package com.example.proyectoghibli.view.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoghibli.adaptadores.AdaptadorPelicula;
import com.example.proyectoghibli.R;
import com.example.proyectoghibli.viewmodel.PeliculasViewModel;

import org.jetbrains.annotations.Nullable;

/**
 *  Nav peliculas.
 */
public class nav_peliculas extends Fragment {
    private PeliculasViewModel peliculasViewModel;
    private RecyclerView recyclerView;
    private AdaptadorPelicula adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_peliculas, container, false);


        recyclerView = view.findViewById(R.id.recyclerPeliculas);
        //dividimos el recycler View en dos columnas
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //observa el cambio que se produzca en la lista de peliculas y lo actualiza
        peliculasViewModel = new ViewModelProvider(this).get(PeliculasViewModel.class);
        peliculasViewModel.obtenerPeliculas().observe(getViewLifecycleOwner(), peliculas -> {

            adaptador = new AdaptadorPelicula(peliculas, getContext());
            recyclerView.setAdapter(adaptador);
        });

        //hacemos la llamada al metodo del ViewModel para cargar las peliculas a traves de la api
        peliculasViewModel.cargarPeliculas();

        return view;
    }
}

