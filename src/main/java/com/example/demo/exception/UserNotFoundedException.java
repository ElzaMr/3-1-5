package com.example.demo.exception;

public class UserNotFoundedException extends RuntimeException {
    public UserNotFoundedException(String message) {
        super(message);
    }
}
