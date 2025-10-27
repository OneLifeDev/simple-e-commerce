package com.onelifedev.userservice.exceptions;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(String message) {
        super(message);
    }
}

// Checked vs Unchecked exceptions.
