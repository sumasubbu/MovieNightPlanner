package au.edu.rmit.movienightplanner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.AbstractEvent;
import au.edu.rmit.movienightplanner.model.AbstractMovie;
import au.edu.rmit.movienightplanner.model.EventInterface;
import au.edu.rmit.movienightplanner.model.MovieInterface;
import au.edu.rmit.movienightplanner.service.EventImpl;
import au.edu.rmit.movienightplanner.service.MovieImpl;
import au.edu.rmit.movienightplanner.utils.FileLoader;

public class EventModel {

    private FileLoader fileLoader;
    private EventInterface eventInterface;
    private MovieInterface movieInterface;
    private static EventModel eventModel = new EventModel();

    private EventModel(){
        this.eventInterface = EventImpl.getEventInterface();
        this.movieInterface = MovieImpl.getMovieInterface();
        this.fileLoader = new FileLoader();
    }

    public static EventModel getEventModel(){
        return eventModel;
    }

    public boolean scheduleEvent(String eventTitle,
                                 LocalDateTime startDate,
                                 LocalDateTime endDate,
                                 String venue,
                                 String location,
                                 AbstractMovie movie) {
        return this.eventInterface.scheduleEvent(eventTitle,
                startDate,
                endDate,
                venue,
                location,
                movie);
    }

    public boolean unscheduleEvent(UUID id) {
        return this.eventInterface.unscheduleEvent(id);
    }

    public boolean editEvent(UUID id,
                             String title,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             String venue,
                             String location,
                             AbstractMovie movie) {
        return this.eventInterface.editEvent(id, title, startDate, endDate, venue, location, movie);
    }

    public Map<UUID, AbstractEvent> viewEvents() {
        return this.eventInterface.getAllEvents();
    }

    public Map<UUID, AbstractMovie> viewMovies() {
        return this.movieInterface.getAllMovies();
    }

    public boolean addMovie(UUID id, AbstractMovie movie) {
        return this.eventInterface.addMovie(id, movie);
    }

    public void loadData() throws IOException {
        Map<UUID, AbstractMovie> movies = fileLoader.loadMovieData();
        Map<UUID, AbstractEvent> events = fileLoader.loadEventData();

        // creating new movies in MovieImpl
        for(Map.Entry<UUID, AbstractMovie> m: movies.entrySet()) {
            AbstractMovie movie = m.getValue();
            this.movieInterface.addMovie(
                movie.getTitle(),
                    movie.getYear(),
                    movie.getPoster()
            );
        }

        // creating new events in EventImpl
        for(Map.Entry<UUID, AbstractEvent> e: events.entrySet()) {
            AbstractEvent event = e.getValue();

            for(Map.Entry<UUID, AbstractMovie> m: movies.entrySet()) {
                this.scheduleEvent(event.getEventTitle(),
                        event.getStartDate(),
                        event.getEndDate(),
                        event.getVenue(),
                        event.getLocation(),
                        m.getValue());
                break;
            }

        }
    }

}
