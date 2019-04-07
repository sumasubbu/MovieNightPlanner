package com.example.MovieNightPlanner.model;

import java.util.UUID;

public class Movie {
    //TODO: should the fields be public?
    private UUID ID;
    private String title;
    private int year;
    private String poster; //TODO: add an image to the poster


    //constructor
    public Movie(UUID ID, String title, int year, String poster){
        this.ID = ID;
        this.title = title;
        this.year = year;
        this.poster = poster;
    }

    //accessors and mutators
    public UUID getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }


    public int getYear() {
        return year;
    }


    public String getPoster() {
        return poster;
    }

}
