package com.example.MovieNightPlanner.service;

import android.content.Context;
import android.util.Log;

import com.example.MovieNightPlanner.MainActivity;
import com.example.MovieNightPlanner.R;
import com.example.MovieNightPlanner.model.Event;
import com.example.MovieNightPlanner.model.EventInterface;
import com.example.MovieNightPlanner.model.Movie;
import com.example.MovieNightPlanner.model.MovieInterface;
import com.example.MovieNightPlanner.utils.DateUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class EventService implements EventInterface {

    private Map<UUID, Event> events;
    private Scanner input = new Scanner(System.in);
    private MovieInterface movies;

    private String TAG = getClass().getName();

    public EventService(MovieInterface movieService) {
        this.events = new HashMap<>();
        this.movies = movieService;
    }

    @Override
    public boolean scheduleEvent(String title,
                                 LocalDateTime startDate,
                                 LocalDateTime endDate,
                                 String venue,
                                 String location,
                                 Movie movie) {
        Event event;

        do {
            event = createEvent(title, startDate, endDate, venue, location, movie);
            if (!events.containsKey(event.getID())) {
                break;
            }
        } while (true);

        events.put(event.getID(), event);
        return true;
    }

    @Override
    public boolean unscheduleEvent(UUID id) {
        events.remove(id);
        return true;
    }

    @Override
    public boolean editEvent(UUID id,
                             String title,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             String venue,
                             String location,
                             Movie movie) {
        Event event = new Event(id, title, startDate, endDate, venue, location, movie);
        events.put(id, event); //will it replace the value of the key?

        return false;
    }

    @Override
    public Map<UUID, Event> viewEvents() {
        return this.events;
    }

    @Override
    public boolean addMovie(UUID id, Movie movie) {
        Event event = events.get(id);
        editEvent(event.getID(),
                event.getEventTitle(),
                event.getStartDate(),
                event.getEndDate(),
                event.getVenue(),
                event.getLocation(),
                movie);

        return false;
    }

    public void loadEventData() throws IOException {
//        File file = new File("/Users/suma/AndroidStudioProjects/MovieNightPlanner/app/src/main/res/raw/events.txt");
//
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//
//        String line;
//        String[] fileString;
//
//        List<Movie> allMovies = this.movies.getAllMovies();
//        System.out.println("Movielist size: " + allMovies.size());
//        while ((line = br.readLine()) != null) {
//            /*System.out.println(fileString.length);
//            System.out.println(line);*/
//            if(!line.matches("//.*")) {
//                fileString = line.split(",");
//                Movie movie = allMovies.get(0);
//
//                Event event = createEvent(fileString[1],
//                        DateUtils.parseDate(fileString[2]),
//                        DateUtils.parseDate(fileString[3]),
//                        fileString[4],
//                        fileString[5] + " " + fileString[6],
//                        movie);
//                events.put(event.getID(), event);
//            }
//
//
//        }
//        br.close();
//
//        events.forEach((k, v) -> {
//            System.out.format("key: %s, value: %s%n", k.toString(), v.getMovie().getTitle());
//        });


        Context context = MainActivity.getAppContext();

        input = new Scanner(context.getResources().openRawResource(R.raw.events));
        //StringBuffer stringBuffer = new StringBuffer();
        String line;
        String[] fileString;
        try {
//            while (input.hasNext()) {
//                String line = input.nextLine();
//                stringBuffer.append(line);
//                stringBuffer.append("\n");
//                Log.i(TAG,line + "event file read");
//            }
            while (input.hasNext()) {
                line = input.nextLine();

                if (!line.matches("//.*")) {
                    fileString = line.split(",");
                    List<Movie> allMovies = this.movies.getAllMovies();

                    Movie movie = allMovies.get(0);

                    Event event = createEvent(fileString[1],
                            DateUtils.parseDate(fileString[2]),
                            DateUtils.parseDate(fileString[3]),
                            fileString[4],
                            fileString[5] + " " + fileString[6],
                            movie);
                    events.put(event.getID(), event);
                }

            }
        } catch (Exception e) {
            Log.i(TAG, e.getMessage());
        } finally {
            if (input != null)
                input.close();

        }


//    //method to get keyboard input from the user and store them as event objects
//    public void readData() {
//
//        System.out.println("Enter the event title");
//        String eventTitle = input.nextLine();
//        System.out.println("Enter the start Date of the event");
//        LocalDateTime startDate = DateUtils.parseDate(input.nextLine());
//        System.out.println("Enter the end Date of the event");
//        LocalDateTime endDate = DateUtils.parseDate(input.nextLine());
//        System.out.println("Enter the venue of the event");
//        String venue = input.nextLine();
//        System.out.println("Enter the location of the event");
//        String location = input.nextLine();
//
//
//        Event event = createEvent(eventTitle, startDate, endDate, venue, location);
//        events.put(event.getID(), event);
//
//    }

        private Event createEvent(String eventTitle, LocalDateTime startDate, LocalDateTime endDate,
                String venue,
                String location,
                Movie movie)
        {
            Event event = new Event(UUID.randomUUID(),
                    eventTitle,
                    startDate,
                    endDate,
                    venue,
                    location,
                    movie);

            return event;
        }
    }



    }
}
