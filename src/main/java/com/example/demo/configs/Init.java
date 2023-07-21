package com.example.demo.configs;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsers() {
        Role userRole = new Role("USER");
        Role adminRole = new Role("ADMIN");

        roleService.saveRole(userRole);
        roleService.saveRole(adminRole);

        Set<Role> adminRolesSet = new HashSet<>();
        adminRolesSet.add(adminRole);
        Set<Role> userRolesSet = new HashSet<>();
        userRolesSet.add(userRole);

        User user = new User("user", "user", 2, "123", userRolesSet);
        User admin = new User("admin", "admin", 2, "123", adminRolesSet);

        userService.save(user);
        userService.save(admin);
    }
}
