package com.example.jwtauth.controller;

import com.example.jwtauth.model.Role;
import com.example.jwtauth.service.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600) //* all origins are allowed
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public List<Role> getAll () {
        return roleService.getAll();
    }
}
