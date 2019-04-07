package au.edu.rmit.movienightplanner.model;

import java.time.LocalDateTime;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.Movie;

public class Event extends AbstractEvent{

    public Event(UUID eventID, String eventTitle, LocalDateTime startDate, LocalDateTime endDate,
                 String venue, String location, AbstractMovie movie){
        super(eventID, eventTitle, startDate, endDate, venue, location, movie);

    }

}
