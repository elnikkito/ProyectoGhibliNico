package com.example.proyectoghibli.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.proyectoghibli.R;
import com.example.proyectoghibli.model.Pelicula;

public class InfoPeliculas extends AppCompatActivity {

    private TextView titulo, descripcion, director, productor, fecha, duracion;
    private ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peliculas);

        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);
        director = findViewById(R.id.director);
        productor = findViewById(R.id.productor);
        fecha = findViewById(R.id.fecha);
        duracion = findViewById(R.id.duracion);
        banner = findViewById(R.id.banner);

        String tituloPelicula = getIntent().getStringExtra("TITULO");
        String descripcionPelicula = getIntent().getStringExtra("DESCRIPCION");
        String directorPelicula = getIntent().getStringExtra("DIRECTOR");
        String productorPelicula = getIntent().getStringExtra("PRODUCTOR");
        String fechaPelicula = getIntent().getStringExtra("FECHA");
        String duracionPelicula = getIntent().getStringExtra("DURACION");
        String bannerPelicula = getIntent().getStringExtra("BANNER");

        titulo.setText(tituloPelicula);
        descripcion.setText(descripcionPelicula);
        director.setText("Director: " + directorPelicula);
        productor.setText("Productor: " + productorPelicula);
        fecha.setText("Fecha de lanzamiento: " + fechaPelicula);
        duracion.setText("Duración: " + duracionPelicula);

        //Cargar el banner usando Glide
        Glide.with(this)
                .load(bannerPelicula)
                .into(banner);
    }

    public void lanzarPeliculas(android.view.View view) {
        Intent intent = new Intent(this, Pelicula.class);
        startActivity(intent);
    }
}
