package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/users")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("listOfUsers", list);
        return "users";
    }

    @GetMapping(value = "/user/{id}")//вход на страничку юзера
    public String getUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("listOfUser", user);
        return "user";
    }
///////////////////////////////////////////////////////////////
    @GetMapping(value = "/new")//создаем нового юзера
    public String newUser(User user, Model model) {
        model.addAttribute("user1", user);
        return "new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        userService.save(user);
        return "redirect:users";
    }
    @GetMapping(value = "/{id}/update")
    public String update(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping(value = "/{id}")
    public String update1(@ModelAttribute("user") User user) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        userService.update(user);
        return "redirect:/admin/users";
    }


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
