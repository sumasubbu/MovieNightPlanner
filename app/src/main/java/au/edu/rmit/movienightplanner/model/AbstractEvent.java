package au.edu.rmit.movienightplanner.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AbstractEvent {
    private UUID eventID;
    private String eventTitle;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String venue;
    private String location;
    // TODO: import contacts into a list? how to do it?
    private AbstractMovie movie; //event has a movie, composition relationship.


    public AbstractEvent(UUID eventID, String eventTitle, LocalDateTime startDate,
                         LocalDateTime endDate, String venue, String location, AbstractMovie movie) {
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

    public AbstractMovie getMovie() {
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

    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", eventTitle='" + eventTitle + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", venue='" + venue + '\'' +
                ", location='" + location + '\'' +
                ", movie=" + movie.toString() +
                '}';
    }

}
