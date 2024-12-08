package com.example.proyectoghibli.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoghibli.R;
import com.example.proyectoghibli.adaptadores.AdaptadorPeliculasPorDirector;
import com.example.proyectoghibli.api.ClienteApi;
import com.example.proyectoghibli.api.ServicioApi;
import com.example.proyectoghibli.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculasPorDirector extends AppCompatActivity {

    private TextView tituloDirector;
    private RecyclerView recyclerPeliculas;
    private AdaptadorPeliculasPorDirector adaptador;
    private List<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_por_director);

        String nombreDirector = getIntent().getStringExtra("nombre_director");

        tituloDirector = findViewById(R.id.tituloDirector);
        recyclerPeliculas = findViewById(R.id.recyclerPeliculasPorDirector);
        recyclerPeliculas.setLayoutManager(new LinearLayoutManager(this));

        tituloDirector.setText("Peliculas dirigidas por: " + nombreDirector);

        cargarPeliculasDelDirector(nombreDirector);
    }

    private void cargarPeliculasDelDirector(String nombreDirector) {
        ServicioApi apiService = ClienteApi.getClient().create(ServicioApi.class);
        apiService.getPeliculas().enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    peliculas = new ArrayList<>();

                    for (Pelicula pelicula : response.body()) {
                        if (pelicula.getDirector().equalsIgnoreCase(nombreDirector)) {
                            peliculas.add(pelicula);
                        }
                    }

                    adaptador = new AdaptadorPeliculasPorDirector(peliculas, PeliculasPorDirector.this);
                    recyclerPeliculas.setAdapter(adaptador);
                }
            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {

            }
        });
    }

    public void lanzarPrincipal(android.view.View view) {
        Intent intent = new Intent(this, PeliculasPorDirector.class);
        startActivity(intent);
    }
}


