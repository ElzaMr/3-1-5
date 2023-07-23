package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repo.RoleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @PostConstruct
    private void init() {
        log.info("init RoleService");
    }

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }

    public Optional<Role> findById(int id) {
        return roleRepo.findById(id);
    }
}