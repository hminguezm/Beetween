package com.beetwen.shared.domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {

    public static String formatter(String dateTime) {
        String[] patterns = {
                "yyyy-MM-dd'T'HH:mm:ss",
                "yyyy-MM-dd-HH:mm:ss",
                "yyyy-MM-dd-HH.mm.ss",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd",
        };

        for (String pattern : patterns) {
            try {
                Date dateParsed = new SimpleDateFormat(pattern).parse(dateTime);
                DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                LocalDateTime dateTimeFormatted = dateParsed.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
                return dateTimeFormatted.format(formatOutput);
            } catch (ParseException ignored) {
                System.out.println("Error exception ignored");
            }
        }

        throw new RuntimeException("Error parsing date and time: A valid format could not be found..");
    }
}