package com.example.demo.controller;

import com.example.demo.model.User;
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


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping(value = "/users")
    public String getAllUsers(Principal principal, Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("listOfUsers", list);
        return "ADMIN/users";
    }

    @GetMapping(value = "/user/{id}")//вход на страничку юзера
    public String getUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("listOfUser", user);
        return "User/user";
    }

    ///////////////////////////////////////////////////////////////
    @GetMapping(value = "/new")//создаем нового юзера
    public String newUser(User user, Model model) {
        model.addAttribute("user1", user);
        return "ADMIN/new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:users";
    }

    @GetMapping(value = "/{id}/update")
    public String update(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "ADMIN/update";
    }

    @PatchMapping(value = "/{id}")
    public String update1(@ModelAttribute("user") User user) {

        userService.update(user);
        return "redirect:users";
    }


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:ADMIN/users";
    }
}
