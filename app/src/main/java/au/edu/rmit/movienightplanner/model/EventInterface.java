package com.example.MovieNightPlanner.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public interface EventInterface {

    public boolean scheduleEvent (String title,
                                  LocalDateTime startDate,
                                  LocalDateTime endDate,
                                  String venue,
                                  String location,
                                  Movie movie);
    public boolean unscheduleEvent(UUID id);
    public boolean editEvent(UUID id,
                             String title,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             String venue,
                             String location,
                             Movie movie);
    public Map<UUID,Event> viewEvents ();
    public boolean addMovie(UUID id, Movie movie);



}
