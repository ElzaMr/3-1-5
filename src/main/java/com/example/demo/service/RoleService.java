package com.example.demo.service;

import com.example.demo.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

public interface RoleService {

    void saveRole(Role role);
    Optional<Role> findById(int id);
}
