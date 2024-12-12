package com.example.proyectoghibli.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoghibli.api.ClienteApi;
import com.example.proyectoghibli.api.ServicioApi;
import com.example.proyectoghibli.model.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculasViewModel extends ViewModel {
    private MutableLiveData<List<Pelicula>> peliculasLiveData;
    private ServicioApi servicioApi;

    /**
     * Instantiates a new Peliculas view model.
     */
    public PeliculasViewModel() {
        peliculasLiveData = new MutableLiveData<>();
        servicioApi = ClienteApi.getClient().create(ServicioApi.class);
    }

    /**
     * Cargar peliculas.
     */
//metodo para cargar las peliculas des de la api
    public void cargarPeliculas() {
        servicioApi.getPeliculas().enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    peliculasLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {

            }
        });
    }

    /**
     * Obtener peliculas live data.
     *
     * @return the live data
     */
//metodo para obtener los datos a traves del live data
    public LiveData<List<Pelicula>> obtenerPeliculas() {
        return peliculasLiveData;
    }
}



