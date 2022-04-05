package com.example.jwtauth.service;

import com.example.jwtauth.exceptions.ProjectNotFoundException;
import com.example.jwtauth.model.Project;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

public interface ProjectService {

    List<Project> getAll();
    Project createProject (String name, Date deadline, String description);

    Project findProjectById(Long id) throws ProjectNotFoundException;
    void deleteProject(Long id) throws ProjectNotFoundException;
}
