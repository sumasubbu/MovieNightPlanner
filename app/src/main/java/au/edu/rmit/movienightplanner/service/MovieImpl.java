package au.edu.rmit.movienightplanner.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.AbstractMovie;
import au.edu.rmit.movienightplanner.model.Movie;
import au.edu.rmit.movienightplanner.model.MovieInterface;


public class MovieImpl implements MovieInterface {

    private Map<UUID, AbstractMovie> movies;
    private String TAG;
    private static MovieInterface movieInterface = new MovieImpl();

    private MovieImpl() {
        this.movies = new HashMap<>();
        this.TAG = this.getClass().getName();
    }

    public static MovieInterface getMovieInterface() {
        return movieInterface;
    }

    @Override
    public boolean addMovie(String title, String year, String poster) {
        AbstractMovie movie;
        do {
            movie = this.createMovie(title, year, poster);
            if (!this.movies.containsKey(movie.getID())) {
                break;
            }
        }while (true);
        this.movies.put(movie.getID(),movie);
        return true;
    }

    private AbstractMovie createMovie(String title, String year, String poster) {
        return new Movie(UUID.randomUUID(), title, year, poster);
    }

    @Override
    public boolean deleteMovie(UUID id) {
        this.movies.remove(id);
        return true;
    }

    @Override
    public boolean editMovie(UUID id, String title, String year,String poster) {
        AbstractMovie movie = new Movie(id,title,year,poster);
        this.movies.put(id,movie);
        return false;
    }

    @Override
    public Map<UUID, AbstractMovie> getAllMovies() {
        return this.movies;
    }

}
