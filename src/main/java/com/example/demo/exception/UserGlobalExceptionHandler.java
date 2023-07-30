package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<UserIncorrectInput> handleException(UserNotFoundedException exception){
        UserIncorrectInput incorrectInput = new UserIncorrectInput();
        incorrectInput.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectInput, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<UserIncorrectInput> handleException(Exception exception){
        UserIncorrectInput incorrectInput = new UserIncorrectInput();
        incorrectInput.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectInput, HttpStatus.BAD_REQUEST);
    }
}
