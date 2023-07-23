package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.Optional;

public interface RoleService {
    void saveRole(Role role);
    Optional<Role> findById(int id);
}
