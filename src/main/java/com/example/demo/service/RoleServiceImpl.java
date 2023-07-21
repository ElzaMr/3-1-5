package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repo.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }


    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }
}
