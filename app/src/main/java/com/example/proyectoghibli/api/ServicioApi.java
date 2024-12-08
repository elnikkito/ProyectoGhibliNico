package com.example.proyectoghibli.api;

import com.example.proyectoghibli.model.Pelicula;
import com.example.proyectoghibli.model.Personaje;
import com.example.proyectoghibli.model.Ubicacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioApi {

    @GET("films")
    Call<List<Pelicula>> getPeliculas();

    @GET("locations")
    Call<List<Ubicacion>> getLocations();

    @GET("people")
    Call<List<Personaje>> getPersonajes();

}

