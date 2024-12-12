package com.example.proyectoghibli.model;

/**
 * The type Personaje.
 */
public class Personaje {
    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;

    // getters y setters

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {return name;}

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {return gender;}

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Gets eye color.
     *
     * @return the eye color
     */
    public String getEye_color() {
        return eye_color;
    }

    /**
     * Sets eye color.
     *
     * @param eye_color the eye color
     */
    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    /**
     * Gets hair color.
     *
     * @return the hair color
     */
    public String getHair_color() {
        return hair_color;
    }

    /**
     * Sets hair color.
     *
     * @param hair_color the hair color
     */
    public void setHair_color(String hair_color) {this.hair_color = hair_color;}

}
