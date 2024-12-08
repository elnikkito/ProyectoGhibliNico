package com.example.proyectoghibli.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoghibli.R;
import com.example.proyectoghibli.adaptadores.AdaptadorDirector;
import com.example.proyectoghibli.api.ClienteApi;
import com.example.proyectoghibli.api.ServicioApi;
import com.example.proyectoghibli.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nav_directores extends Fragment {

    private RecyclerView recyclerView;
    private AdaptadorDirector adaptadorDirector;
    private List<String> listaDirectores;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_directores, container, false);

        recyclerView = view.findViewById(R.id.recyclerDirectores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cargarDirectoresDesdeApi();

        return view;
    }

    private void cargarDirectoresDesdeApi() {
        ServicioApi apiService = ClienteApi.getClient().create(ServicioApi.class);
        apiService.getPeliculas().enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listaDirectores = new ArrayList<>();

                    for (Pelicula pelicula : response.body()) {
                        if (pelicula.getDirector() != null && !listaDirectores.contains(pelicula.getDirector())) {
                            listaDirectores.add(pelicula.getDirector());
                        }
                    }

                    adaptadorDirector = new AdaptadorDirector(listaDirectores, getContext());
                    recyclerView.setAdapter(adaptadorDirector);
                }
            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {

            }
        });
    }
}