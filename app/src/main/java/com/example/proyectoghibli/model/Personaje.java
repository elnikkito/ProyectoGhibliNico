package com.example.proyectoghibli.model;

public class Personaje {
    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;

    // getters y setters

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {return gender;}

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {this.hair_color = hair_color;}

}
