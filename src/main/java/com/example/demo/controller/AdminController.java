package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;


@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping ("/admin")
    public String showAllUsers(Model model, Principal principal) {
        User principalUser = userService.getUserByUsername(principal.getName());
        model.addAttribute("principalUser", principalUser);
        return "admin";
    }

    @GetMapping("/currentUser")
    public String showUser(Model model, Principal principal) {
        User principalUser = userService.findByName(principal.getName());
        model.addAttribute("principalUser", principalUser);
        return "user";
    }
}