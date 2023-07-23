package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
//        this.passwordEncoder = passwordEncoder;
        this.passwordEncoder = passwordEncoder;
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
        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        Optional<Role> role = roleRepo.findById(2);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role.get());
        user.setRoles(roleSet);
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
        updatedUser.setPass(passwordEncoder.encode(updatedUser.getPass()));
        Optional<Role> role = roleRepo.findById(1);
        Role role1 = role.get();

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
