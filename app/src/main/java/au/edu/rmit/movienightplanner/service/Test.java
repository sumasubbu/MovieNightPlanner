package com.example.MovieNightPlanner.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]) {

//        String line = "// Id, Title, Start Date, End Date, Venue, Location (latitude/longitude)";
//
//        System.out.println(line.matches("//.*")?"true":"false");
//
        String date = "3/01/2019 2:00:00 AM";

        DateTimeFormatter format1 =DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
        DateTimeFormatter format2 =DateTimeFormatter.ofPattern("d/MM/yyyy hh:mm:ss a");
        DateTimeFormatter format3 =DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm:ss a");
        DateTimeFormatter format4 =DateTimeFormatter.ofPattern("d/MM/yyyy h:mm:ss a");

        List<DateTimeFormatter> formats = new ArrayList<>();
        formats.add(format1);
        formats.add(format2);
        formats.add(format3);
        formats.add(format4);

        LocalDateTime startDate = null;

        for(DateTimeFormatter format: formats) {
            try {
                startDate = LocalDateTime.parse(date, format);
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        }

//        LocalDateTime startDate = LocalDateTime.parse(date,dateTimeFormatter);
        System.out.println(startDate.toString());
    }
}
