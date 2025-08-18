package org.example.globals.utils;

import org.example.globals.exceptions.ErrorMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeValidator {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, FORMATTER);
    }
    public static LocalDate parseDate(String dateStr) { return LocalDate.parse(dateStr, DATE_FORMATTER);}
    public static void validateItineraryTimes(String departureTime, String arrivalTime, String checkIn, String checkOut) {
        LocalDateTime dep = parseTime(departureTime);
        LocalDateTime arr = parseTime(arrivalTime);
        LocalDateTime in = parseTime(checkIn);
        LocalDateTime out = parseTime(checkOut);

        if (arr.isBefore(dep)) {
            throw new IllegalArgumentException(ErrorMessage.ARRIVAL_BEFORE_DEPARTURE.getMessage());
        }

        if (out.isBefore(in)) {
            throw new IllegalArgumentException(ErrorMessage.CHECKOUT_BEFORE_CHECKIN.getMessage());
        }
    }
    public static void validateTripDates(String StartDate, String EndDate) {
        LocalDate start = parseDate(StartDate);
        LocalDate end = parseDate(EndDate);

        if (end.isBefore(start)) {
            throw new IllegalArgumentException(ErrorMessage.START_BEFORE_END.getMessage());
        }
    }

}
