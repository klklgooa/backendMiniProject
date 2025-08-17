package org.example.globals.exceptions;

import java.io.IOException;

public class FileLoadException extends RuntimeException {

    public FileLoadException(String message, IOException e) {
        super(message, e);
    }

    public FileLoadException(String message) {
        super(message);
    }
}
