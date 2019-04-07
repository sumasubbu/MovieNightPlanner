package au.edu.rmit.movienightplanner.controller;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.Event;
import au.edu.rmit.movienightplanner.service.EventImpl;
import au.edu.rmit.movienightplanner.service.MovieImpl;

public class MainActivityController {
    private static final String TAG = "Main activity controller";
//    private MovieImpl movieService = new MovieImpl();
//
//
//    public ArrayList<Event> getAllEvents() throws IOException {
//
//        movieService.loadMovieData();
//        EventImpl eventService = new EventImpl(movieService);
//        eventService.loadEventData();
//
//
//        Map<UUID,Event> eventsMap = eventService.getAllEvents();
//        for (Map.Entry<UUID,Event> entry:eventsMap.entrySet()
//        ) {
//            Event event = entry.getValue();
//            Log.i(TAG, event.getEventTitle());
//
//        }
//
//        Collection<Event> events = eventsMap.values();
//        ArrayList<Event> eventsList = new ArrayList<>(events);
//
//        for (int i = 0; i < eventsList.size(); i++) {
//            System.out.println(eventsList.get(i)+"\n");
//
//        }
//        return eventsList;
//    }
}
