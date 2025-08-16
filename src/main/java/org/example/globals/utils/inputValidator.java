package org.example.globals.utils;

import org.example.globals.exceptions.InputException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator {

    public static String validateAndFormatDate(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/M/d");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(input, inputFormatter);
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new InputException("잘못된 날짜 형식입니다. YYYY/MM/DD 형식으로 입력해주세요.");
        }
    }

    public static String validateAndFormatDateTime(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/M/d-HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);
            return dateTime.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new InputException("잘못된 날짜 형식입니다. YYYY/MM/DD-HH:mm 형식으로 입력해주세요.");
        }
    }
}
