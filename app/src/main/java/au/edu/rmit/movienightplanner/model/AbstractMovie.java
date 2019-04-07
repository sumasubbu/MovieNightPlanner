package au.edu.rmit.movienightplanner.model;

import java.util.UUID;

public abstract class AbstractMovie {
    //TODO: should the fields be public?
    private UUID ID;
    private String title;
    private String year;
    private String poster; //TODO: add an image to the poster


    //constructor
    public AbstractMovie(UUID ID, String title, String year, String poster){
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


    public String getYear() {
        return year;
    }


    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", poster='" + poster + '\'' +
                '}';
    }
}
