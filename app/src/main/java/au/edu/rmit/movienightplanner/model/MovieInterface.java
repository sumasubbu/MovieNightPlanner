package com.example.MovieNightPlanner.model;

import java.util.List;
import java.util.UUID;

public interface MovieInterface {

    public boolean addMovie(String title, int year, String poster);
    public boolean deleteMovie(UUID id);
    public boolean editMovie(UUID id,String title, int year, String poster);
    public List<Movie> getAllMovies();
}
