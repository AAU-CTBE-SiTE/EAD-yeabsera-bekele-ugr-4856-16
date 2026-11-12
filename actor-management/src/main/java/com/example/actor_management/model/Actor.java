package com.example.actor_management.model;

public class Actor {

    private Long id;
    private String name;
    private String movie;

    public Actor() {
    }

    public Actor(Long id, String name, String movie) {
        this.id = id;
        this.name = name;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}