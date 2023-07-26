package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);
    public List<Role> getAllRoles();
}
