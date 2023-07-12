package com.example.demo.Dao;



import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void save(User user);
    public void update(User updatedUser);
    public void delete(int id);
}
