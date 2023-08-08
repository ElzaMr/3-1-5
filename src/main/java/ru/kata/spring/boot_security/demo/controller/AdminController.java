package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

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
        model.addAttribute("allUsers", userService.findAll());
        User principalUser = userService.findByName(principal.getName());
        model.addAttribute("principalUser", principalUser);
        model.addAttribute("newUser", new User ());
        model.addAttribute("allRoles", roleService.getRoles());
        model.addAttribute("titleTable1", "Список всех пользователей:");
        return "admin";
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
        User principalUser = userService.findByName(principal.getName());
        model.addAttribute("principalUser", principalUser);
        return "user";
    }
}

