package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(Principal principal, Model model) {
        model.addAttribute("principalUser", userService.getUserByUsername(principal.getName()));
        List<Role> listOfRoles = roleService.getAllRoles();
        model.addAttribute("listOfRoles", listOfRoles);
        return "ADMIN/admin";
    }
//    @GetMapping(value = "/adminUser")
//    public String getAdminUser(Principal principal, Model model) {
//        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
//        return "ADMIN/adminPage";
//    }
}