package com.onelifedev.userservice.exceptions;

public class PasswordMismatchException extends Exception {
    public PasswordMismatchException(String message) {
        super(message);
    }
}
