package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void init() {
        log.info("init UserService");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        User user = userRepo.findById(id).orElse(null);
        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void saveInit(User user) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void update(User updatedUser) {
        userRepo.save(updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }
}
