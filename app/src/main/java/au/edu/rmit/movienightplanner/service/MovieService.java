package com.example.MovieNightPlanner.service;

import android.content.Context;
import android.util.Log;

import com.example.MovieNightPlanner.MainActivity;
import com.example.MovieNightPlanner.R;
import com.example.MovieNightPlanner.model.Movie;
import com.example.MovieNightPlanner.model.MovieInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class MovieService implements MovieInterface {

    private Map<UUID, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    Scanner input = new Scanner(System.in);

    private String TAG = getClass().getName();

    public void readMovies(){
        System.out.println("Enter the movie title");
        String movieTitle = input.nextLine();
        System.out.println("Enter the year of the movie");
        int year = input.nextInt();
        System.out.println("Enter the poster of the movie");
        String poster = input.nextLine();

        Movie movie = createMovie(movieTitle, year, poster);
        movies.put(movie.getID(),movie);
    }


    @Override
    public boolean addMovie(String title, int year, String poster) {
        Movie movie;
        do {
            movie = createMovie(title, year, poster);
            if (!movies.containsKey(movie.getID())) {
                break;
            }
        }while (true);
        //Movie movie = createMovie(title,year,poster);
        movies.put(movie.getID(),movie);
        return true;
    }

    @Override
    public boolean deleteMovie(UUID id) {
        movies.remove(id);
        return true;
    }

    @Override
    public boolean editMovie(UUID id, String title, int year,String poster) {
        Movie movie = new Movie(id,title,year,poster);
        movies.put(id,movie);
        return false;
    }

    @Override
    public List<Movie> getAllMovies() {
        System.out.println("Movies size: " + this.movies.size());
        return new ArrayList<Movie>(this.movies.values());
    }

    public Movie createMovie(String title, int year, String poster){
        Movie movie = new Movie(UUID.randomUUID(),title,year,poster);
        return movie;
    }

    public void loadMovieData() throws IOException {
        Context context = MainActivity.getAppContext();

//        File file = new File("/Users/suma/AndroidStudioProjects/MovieNightPlanner/app/src/res/raw/movies.txt");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line;
//        while ((line=bufferedReader.readLine())!=null){
//            if(!line.matches("//.*")){
//                String[] string = line.split(",");
//                String year = string[2].replace("\"","");
//
//                Movie movie = createMovie(string[1],Integer.parseInt(year),string[3]);
//                this.movies.put(movie.getID(),movie);
//            }
//        }
//        this.movies.forEach((k,v) ->{
//                    System.out.format("Movie data --- key: %s, value: %s%n", k.toString(), v.getTitle());
//                });



//
        input = new Scanner(context.getResources().openRawResource(R.raw.movies));
        StringBuffer stringBuffer = new StringBuffer();
        try {
            while (input.hasNext()) {
                String line = input.nextLine();
                stringBuffer.append(line);
                stringBuffer.append("\n");
                Log.i(TAG,line + "file read activity");
            }
        }
        catch (Exception e){
            Log.i(TAG, e.getMessage());
        }
        finally {
            if(input!=null)
                input.close();

        }

    }
}
