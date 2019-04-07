package au.edu.rmit.movienightplanner.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public interface EventInterface {

    public boolean scheduleEvent (String title,
                                  LocalDateTime startDate,
                                  LocalDateTime endDate,
                                  String venue,
                                  String location,
                                  AbstractMovie movie);
    public boolean unscheduleEvent(UUID id);
    public boolean editEvent(UUID id,
                             String title,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             String venue,
                             String location,
                             AbstractMovie movie);
    public Map<UUID, AbstractEvent> getAllEvents();
    public boolean addMovie(UUID id, AbstractMovie movie);



}
