package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User findByName(String username);

    User getUser(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
