package com.example.proyectoghibli.view.activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.proyectoghibli.R;

/**
 * Info peliculas.
 */
public class InfoPeliculas extends AppCompatActivity {

    private TextView titulo, descripcion, director, productor, fecha, duracion;
    private ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peliculas);

        //realizamos la asigancion de las variables segun el xml, para mostrarlos

        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);
        director = findViewById(R.id.director);
        productor = findViewById(R.id.productor);
        fecha = findViewById(R.id.fecha);
        duracion = findViewById(R.id.duracion);
        banner = findViewById(R.id.banner);

        //recupera los datos de el Adaptador
        String tituloPelicula = getIntent().getStringExtra("titulo");
        String descripcionPelicula = getIntent().getStringExtra("descripcion");
        String directorPelicula = getIntent().getStringExtra("director");
        String productorPelicula = getIntent().getStringExtra("productor");
        String fechaPelicula = getIntent().getStringExtra("fecha");
        String duracionPelicula = getIntent().getStringExtra("duracion");
        String bannerPelicula = getIntent().getStringExtra("banner");

        //establecemos como se mostraran los datos
        titulo.setText(tituloPelicula);
        descripcion.setText(descripcionPelicula);
        director.setText("Director: " + directorPelicula);
        productor.setText("Productor: " + productorPelicula);
        fecha.setText("Fecha de lanzamiento: " + fechaPelicula);
        duracion.setText("Duración: " + duracionPelicula);

        //carga el banner usando Glide
        Glide.with(this)
                .load(bannerPelicula)
                .into(banner);
    }
}
