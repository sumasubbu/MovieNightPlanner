package com.example.MovieNightPlanner.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event {
    private UUID eventID;
    private String eventTitle;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String venue;
    private String location;
    // TODO: import contacts into a list? how to do it?
    private Movie movie; //event has a movie, composition relationship.


    public Event(UUID eventID,
                 String eventTitle,
                 LocalDateTime startDate,
                 LocalDateTime endDate,
                 String venue,
                 String location,
                 Movie movie) {
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.venue = venue;
        this.location = location;
        this.movie = movie;
    }

    public UUID getID() {
        return eventID;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime  getEndDate() {
        return endDate;
    }

    public String getVenue() {
        return venue;
    }

    public String getLocation() {
        return location;
    }
}
