package au.edu.rmit.movienightplanner.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.Movie;

public interface MovieInterface {

    public boolean addMovie(String title, String year, String poster);
    public boolean deleteMovie(UUID id);
    public boolean editMovie(UUID id,String title, String year, String poster);
    public Map<UUID, AbstractMovie> getAllMovies();
}
