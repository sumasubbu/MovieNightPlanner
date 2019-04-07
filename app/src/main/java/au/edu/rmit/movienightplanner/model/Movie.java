package au.edu.rmit.movienightplanner.model;

import java.util.UUID;

public class Movie extends AbstractMovie {

    public Movie(UUID ID, String title, String year, String poster) {
        super(ID, title, year, poster);
    }
}
