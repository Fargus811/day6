package com.sergeev.day6.model.exception;

public class LibraryException extends Exception {

    public LibraryException() {
        super();
    }

    public LibraryException(String message) {
        super(message);
    }

    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryException(Throwable cause) {
        super(cause);
    }
}