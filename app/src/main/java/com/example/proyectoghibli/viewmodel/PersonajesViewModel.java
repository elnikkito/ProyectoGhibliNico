package com.example.proyectoghibli.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.proyectoghibli.api.ClienteApi;
import com.example.proyectoghibli.api.ServicioApi;
import com.example.proyectoghibli.model.Personaje;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonajesViewModel extends ViewModel {
    private MutableLiveData<List<Personaje>> personajesLiveData;
    private ServicioApi servicioApi;

    public PersonajesViewModel() {
        personajesLiveData = new MutableLiveData<>();
        servicioApi = ClienteApi.getClient().create(ServicioApi.class);
    }

    /**
     * Cargar personajes.
     */
//metodo para cargar los personages des de la api
    public void cargarPersonajes() {
        servicioApi.getPersonajes().enqueue(new Callback<List<Personaje>>() {
            @Override
            public void onResponse(Call<List<Personaje>> call, Response<List<Personaje>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    personajesLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Personaje>> call, Throwable t) {

            }
        });
    }

    /**
     * Obtener personajes live data.
     *
     * @return the live data
     */
//metodo con el que se podran obtener los personajes a trabes del LiveData
    public LiveData<List<Personaje>> obtenerPersonajes() {
        return personajesLiveData;
    }

    /**
     * Filtrar personajes list.
     *
     * @param personajes the personajes
     * @param intro      the intro
     * @return the list
     */
//metodo para filtrar personajes
    public List<Personaje> filtrarPersonajes(List<Personaje> personajes, String intro) {
        if (intro == null || intro.isEmpty()) {
            return personajes;
        }
        List<Personaje> personajesFiltrados = new ArrayList<>();
        for (Personaje personaje : personajes) {
            if (personaje.getName().toLowerCase().contains(intro.toLowerCase())) {
                personajesFiltrados.add(personaje);
            }
        }
        return personajesFiltrados;
    }
}
