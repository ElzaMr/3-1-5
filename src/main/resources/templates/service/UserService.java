package com.example.SpringBoot.service;


import com.example.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void save(User user);
    public void update(User updatedUser);
    public void delete(int id);
}
