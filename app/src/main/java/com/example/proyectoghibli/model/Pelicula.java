package com.example.proyectoghibli.model;

/**
 * The type Pelicula.
 */
public class Pelicula {
    private String title;
    private String image;
    private String description;
    private String director;
    private String producer;
    private String release_date;
    private String running_time;
    private String movie_banner;

    /**
     * Gets title.
     *
     * @return the title
     */
// getters y setters
    public String getTitle() {return title;}

    /**
     * Gets movie banner.
     *
     * @return the movie banner
     */
    public String getMovie_banner() {
        return movie_banner;
    }

    /**
     * Sets movie banner.
     *
     * @param movie_banner the movie banner
     */
    public void setMovie_banner(String movie_banner) {
        this.movie_banner = movie_banner;
    }

    /**
     * Gets running time.
     *
     * @return the running time
     */
    public String getRunning_time() {
        return running_time;
    }

    /**
     * Sets running time.
     *
     * @param running_time the running time
     */
    public void setRunning_time(String running_time) {
        this.running_time = running_time;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets producer.
     *
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Sets producer.
     *
     * @param producer the producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * Gets release date.
     *
     * @return the release date
     */
    public String getRelease_date() {
        return release_date;
    }

    /**
     * Sets release date.
     *
     * @param release_date the release date
     */
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
