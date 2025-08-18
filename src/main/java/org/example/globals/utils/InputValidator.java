package org.example.globals.utils;

import org.example.globals.exceptions.ErrorMessage;
import org.example.globals.exceptions.InputException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator {

    public static void validateInitialInput(int input) {
        if (input < 1 || input > 4) {
            throw new InputException("1, 2, 3, 4 중 하나를 입력해야 합니다.");
        }
    }

    public static String validateAndFormatDate(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/M/d");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(input, inputFormatter);
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new InputException(ErrorMessage.INVALID_DATE_FORMAT.getMessage());
        }
    }

    public static String validateAndFormatDateTime(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/M/d-HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);
            return dateTime.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new InputException(ErrorMessage.INVALID_TIME_FORMAT.getMessage());

        }
    }
}