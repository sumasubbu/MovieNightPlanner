package au.edu.rmit.movienightplanner.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.AbstractEvent;
import au.edu.rmit.movienightplanner.model.AbstractMovie;
import au.edu.rmit.movienightplanner.model.Event;
import au.edu.rmit.movienightplanner.model.EventInterface;

public class EventImpl implements EventInterface {

    private Map<UUID, AbstractEvent> events;
    private static EventInterface eventInterface = new EventImpl();

    private EventImpl() {
        this.events = new HashMap<>();
    }

    public static EventInterface getEventInterface() {
        return eventInterface;
    }

    @Override
    public boolean scheduleEvent(String title,
                                 LocalDateTime startDate,
                                 LocalDateTime endDate,
                                 String venue,
                                 String location,
                                 AbstractMovie movie) {
        AbstractEvent event;

        do {
            event = createEvent(title, startDate, endDate, venue, location, movie);
            if (!this.events.containsKey(event.getID())) {
                break;
            }
        } while (true);

        events.put(event.getID(), event);
        return true;
    }

    @Override
    public boolean unscheduleEvent(UUID id) {
        this.events.remove(id);
        return true;
    }

    @Override
    public boolean editEvent(UUID id,
                             String title,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             String venue,
                             String location,
                             AbstractMovie movie) {
        AbstractEvent event = new Event(id, title, startDate, endDate, venue, location, movie);
        this.events.put(id, event); //will it replace the value of the key?

        return false;
    }

    @Override
    public Map<UUID, AbstractEvent> getAllEvents() {
        return this.events;
    }

    @Override
    public boolean addMovie(UUID id, AbstractMovie movie) {
        AbstractEvent event = this.events.get(id);
        editEvent(event.getID(),
                event.getEventTitle(),
                event.getStartDate(),
                event.getEndDate(),
                event.getVenue(),
                event.getLocation(),
                movie);

        return false;
    }

    private AbstractEvent createEvent(String eventTitle, LocalDateTime startDate, LocalDateTime endDate,
                              String venue,
                              String location,
                                      AbstractMovie movie)
    {
        AbstractEvent event = new Event(UUID.randomUUID(),
                eventTitle,
                startDate,
                endDate,
                venue,
                location,
                movie);

        return event;
    }

    }