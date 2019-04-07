package com.example.MovieNightPlanner;

import com.example.MovieNightPlanner.controller.MainActivityController;
import com.example.MovieNightPlanner.model.Event;
import com.example.MovieNightPlanner.service.EventService;
import com.example.MovieNightPlanner.service.MovieService;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        MovieService movieService = new MovieService();
        movieService.loadMovieData();
        EventService eventService = new EventService(movieService);
        eventService.loadEventData();
        MainActivityController mainActivityController = new MainActivityController();
        ArrayList<Event> events = new ArrayList<>(mainActivityController.getAllEvents());
    }
}
