package com.example.proyectoghibli.model;

public class Pelicula {
    private String title;
    private String image;
    private String description;
    private String director;
    private String producer;
    private String release_date;
    private String running_time;
    private String movie_banner;

    // Getters y setters para todos los campos
    public String getTitle() {
        return title;
    }

    public String getMovie_banner() {
        return movie_banner;
    }

    public void setMovie_banner(String movie_banner) {
        this.movie_banner = movie_banner;
    }

    public String getRunning_time() {
        return running_time;
    }

    public void setRunning_time(String running_time) {
        this.running_time = running_time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
