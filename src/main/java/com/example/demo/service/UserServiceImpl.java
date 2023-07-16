package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    public UserServiceImpl( UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        User user = userRepo.findById(id).orElse(null);
//        Hibernate.initialize(user.getRoleSet());
        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
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
}
