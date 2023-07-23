package com.example.demo.repo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
@Repository

public interface RoleRepo extends JpaRepository<Role, Integer> {



}
