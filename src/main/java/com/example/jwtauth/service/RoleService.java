package com.example.jwtauth.service;

import com.example.jwtauth.model.Flag;
import com.example.jwtauth.model.Role;
import com.example.jwtauth.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
