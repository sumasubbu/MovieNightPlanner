package au.edu.rmit.movienightplanner.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DateUtils {
    private static List<String> stringFormats = Arrays.asList("dd/MM/yyyy hh:mm:ss a",
        "d/MM/yyyy hh:mm:ss a",
        "dd/MM/yyyy h:mm:ss a",
        "d/MM/yyyy h:mm:ss a");

    public static LocalDateTime parseDate(String dateTime) {
        List<DateTimeFormatter> formats = stringFormats.stream().map(x -> {
            return DateTimeFormatter.ofPattern(x);
        }).collect(toList());

        LocalDateTime localDateTime = null;

        for(DateTimeFormatter format: formats) {
            try {
                localDateTime = LocalDateTime.parse(dateTime, format);
            } catch (Exception e) {
//                System.out.println(e.getMessage());
            }
        }
        return localDateTime;
    }
}
