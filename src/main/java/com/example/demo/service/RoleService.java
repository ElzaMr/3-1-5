package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {
    public Role findRoleById(Long id);

    public List<Role> getAllRoles();

    List<Role> getRoles();

    public void save(Role role);
}
