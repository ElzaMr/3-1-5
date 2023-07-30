package com.example.demo.controller;

import com.example.demo.exception.UserIncorrectInput;
import com.example.demo.exception.UserNotFoundedException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return list;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) throws Exception {
        if(userService.getUserById(id) == null) {
            throw new UserNotFoundedException("User not founded");
        }
        return userService.getUserById(id);
    }

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
        return new ResponseEntity<>(incorrectInput, HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/adminUser")
//    public String getAdminUser(Principal principal, Model model) {
//        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
//        return "ADMIN/adminPage";
//    }
//
//    @GetMapping()
//    public String getAllUser(Principal principal, Model model) {
//        model.addAttribute("admin", userService.getUserByUsername(principal.getName()));
//        List<Role> listOfRoles = roleService.getAllRoles();
//        model.addAttribute("listOfRoles", listOfRoles);
//        return "ADMIN/users";
//    }
//
//    @GetMapping(value = "/user/{id}")
//    public String getUser(@PathVariable("id") int id, Model model) {
//        User user = userService.getUserById(id);
//        model.addAttribute("listOfUser", user);
//        return "User/user";
//    }
//
//    @GetMapping(value = "/new")
//    public String newUser(User user, Model model, Principal principal) {
//        model.addAttribute("user1", user);
//        model.addAttribute("admin", userService.getUserByUsername(principal.getName()));
//        List<Role> listOfRoles = roleService.getAllRoles();
//        model.addAttribute("listOfRoles", listOfRoles);
//        return "ADMIN/new";
//    }
//
//    @PostMapping(value = "/users")
//    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            return "redirect:/admin/new";
//        }
//        userService.save(user);
//        return "redirect:/admin/users";
//    }
//
//    @GetMapping(value = "/{id}/update")
//    public String update(Model model, @PathVariable("id") Integer id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "ADMIN/update";
//    }
//
//    @PatchMapping(value = "/{id}")
//    public String updateUser(@ModelAttribute("user") User user) {
//        userService.update(user);
//        return "redirect:users";
//    }
//
//    @DeleteMapping("/{id}/delete")
//    public String delete(@PathVariable("id") int id) {
//        userService.delete(id);
//        return "redirect:/admin/users";
//    }
}
