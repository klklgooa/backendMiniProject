package org.example.globals.exceptions;

public class ExitException extends RuntimeException {
    public ExitException(String errorMessage) {
        super(errorMessage);
    }
}
