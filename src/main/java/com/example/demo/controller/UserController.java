package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/api/currentUser")
    public ResponseEntity<User> showUser(Principal principal) {
        User user = userService.getUserByUsername(principal.getName());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
