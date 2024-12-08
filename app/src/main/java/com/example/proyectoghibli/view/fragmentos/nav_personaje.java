package com.example.proyectoghibli.view.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoghibli.R;
import com.example.proyectoghibli.adaptadores.AdaptadorPersonaje;
import com.example.proyectoghibli.model.Personaje;
import com.example.proyectoghibli.api.ServicioApi;
import com.example.proyectoghibli.api.ClienteApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nav_personaje extends Fragment {

    private RecyclerView recyclerPersonajes;
    private AdaptadorPersonaje adaptadorPersonaje;
    private List<Personaje> listaPersonajes = new ArrayList<>();
    private List<Personaje> listaPersonajesOriginal = new ArrayList<>();
    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_personajes, container, false);

        recyclerPersonajes = view.findViewById(R.id.recyclerPersonajes);
        searchView = view.findViewById(R.id.searchView);

        recyclerPersonajes.setLayoutManager(new GridLayoutManager(getContext(), 2));

        obtenerPersonajes();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filtrarPersonajes(query);
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

    private void obtenerPersonajes() {
        ServicioApi apiService = ClienteApi.getClient().create(ServicioApi.class);
        Call<List<Personaje>> call = apiService.getPersonajes();

        call.enqueue(new Callback<List<Personaje>>() {
            @Override
            public void onResponse(Call<List<Personaje>> call, Response<List<Personaje>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listaPersonajes = response.body();
                    listaPersonajesOriginal = new ArrayList<>(listaPersonajes);

                    adaptadorPersonaje = new AdaptadorPersonaje(getContext(), listaPersonajes);
                    recyclerPersonajes.setAdapter(adaptadorPersonaje);
                } else {
                    Toast.makeText(getContext(), "Error al obtener personajes", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Personaje>> call, Throwable t) {
                Toast.makeText(getContext(), "Fallo en la conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filtrarPersonajes(String query) {
        if (query == null || query.isEmpty()) {
            listaPersonajes.clear();
            listaPersonajes.addAll(listaPersonajesOriginal);
        } else {
            List<Personaje> listaFiltrada = new ArrayList<>();
            for (Personaje personaje : listaPersonajesOriginal) {
                if (personaje.getName().toLowerCase().contains(query.toLowerCase())) {
                    listaFiltrada.add(personaje);
                }
            }
            listaPersonajes.clear();
            listaPersonajes.addAll(listaFiltrada);
        }
        adaptadorPersonaje.notifyDataSetChanged();
    }
}