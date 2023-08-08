package com.example.demo.config;

import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    public Init( UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }
    @PostConstruct
    public void addAdmin(){
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.save(roleAdmin);
        roleService.save(roleUser);
        Set<Role> adminSet = new HashSet<>();
        adminSet.add(roleAdmin);

        Set<Role> userSet = new HashSet<>();
        userSet.add(roleUser);

        User admin = new User("admin","admin",20,"123",adminSet);
        userService.saveUser(admin);

        User user = new User("user","user",20,"123",userSet);
        userService.saveUser(user);
    }
}
