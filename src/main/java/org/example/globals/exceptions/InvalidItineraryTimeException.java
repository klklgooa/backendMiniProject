package org.example.globals.exceptions;

public class InvalidItineraryTimeException extends RuntimeException {

    public InvalidItineraryTimeException(String message) {
        super(message);
    }
}
