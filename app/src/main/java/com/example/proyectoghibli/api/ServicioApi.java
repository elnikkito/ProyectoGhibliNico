package com.example.proyectoghibli.api;

import com.example.proyectoghibli.model.Pelicula;
import com.example.proyectoghibli.model.Personaje;
import com.example.proyectoghibli.model.Ubicacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * The interface Servicio api.
 */
public interface ServicioApi {

    /**
     * Gets peliculas.
     *
     * @return the peliculas
     */
    @GET("films")
    Call<List<Pelicula>> getPeliculas();

    /**
     * Gets locations.
     *
     * @return the locations
     */
    @GET("locations")
    Call<List<Ubicacion>> getLocations();

    /**
     * Gets personajes.
     *
     * @return the personajes
     */
    @GET("people")
    Call<List<Personaje>> getPersonajes();

}

