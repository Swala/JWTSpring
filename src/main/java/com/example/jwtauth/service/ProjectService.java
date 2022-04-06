package com.example.jwtauth.service;

import com.example.jwtauth.dto.UpdateProjectDTO;
import com.example.jwtauth.exceptions.ProjectNotFoundException;
import com.example.jwtauth.model.Flag;
import com.example.jwtauth.model.Project;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

//Interface mainly helps with testing, and also loose coupling
public interface ProjectService {

    List<Project> getAll();
    Project createProject (String name, Date deadline, String description);

    Project findProjectById(Long id) throws ProjectNotFoundException;
    void deleteProject(Long id) throws ProjectNotFoundException;

    Project updateProject(Long id, String name, Date deadline, String description, Integer flagId) throws ProjectNotFoundException;

}
