package au.edu.rmit.movienightplanner.utils;

import android.util.Log;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import au.edu.rmit.movienightplanner.MainActivity;
import au.edu.rmit.movienightplanner.R;
import au.edu.rmit.movienightplanner.model.AbstractEvent;
import au.edu.rmit.movienightplanner.model.AbstractMovie;
import au.edu.rmit.movienightplanner.model.Event;
import au.edu.rmit.movienightplanner.model.Movie;

import static au.edu.rmit.movienightplanner.MainActivity.TAG;

public class FileLoader {

    private Scanner scanner;

    public Map<UUID, AbstractMovie> loadMovieData() throws IOException {
        Map<UUID, AbstractMovie> movies = new HashMap<>();

        scanner = new Scanner(MainActivity.appContext.getResources().openRawResource(R.raw.movies));
        String[] fileString;
        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (!line.matches("//.*")) {
                    fileString = line.split(",");

                    AbstractMovie movie = createMovie(fileString[1],
                            fileString[2],
                            fileString[3]);
                    movies.put(movie.getID(), movie);
                }


            }
        }
        catch (Exception e){
            Log.e("exception blah blah", e.getMessage());
        }

        return movies;

    }



    public Map<UUID, AbstractEvent> loadEventData() throws IOException {
        Map<UUID, AbstractEvent> events = new HashMap<>();

        scanner = new Scanner(MainActivity.appContext.getResources().openRawResource(R.raw.events));
        String line;
        String[] fileString;
        try {
            while (scanner.hasNext()) {
                line = scanner.nextLine();

                if (!line.matches("//.*")) {
                    fileString = line.split(",");
                    AbstractEvent event = createEvent(fileString[1],
                            DateUtils.parseDate(fileString[2]),
                            DateUtils.parseDate(fileString[3]),
                            fileString[4],
                            fileString[5] + " " + fileString[6],
                            null);
                    events.put(event.getID(), event);
                }

            }
        } catch (Exception e) {
            Log.i(TAG, e.getMessage());
        }
        return events;
    }

    private AbstractEvent createEvent(String eventTitle, LocalDateTime startDate, LocalDateTime endDate,
                              String venue,
                              String location,
                              Movie movie)
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

    private AbstractMovie createMovie(String title, String year, String poster){
        AbstractMovie movie = new Movie(UUID.randomUUID(),title,year,poster);
        return movie;
    }


}
