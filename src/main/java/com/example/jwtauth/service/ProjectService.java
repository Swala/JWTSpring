package com.example.jwtauth.service;

import com.example.jwtauth.dto.CreateProjectDTO;
import com.example.jwtauth.exceptions.ProjectNotFoundException;
import com.example.jwtauth.model.EFlag;
import com.example.jwtauth.model.Flag;
import com.example.jwtauth.model.Project;
import com.example.jwtauth.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ProjectService {

    List<Project> getAll();
    Project createProject (String name, Date deadline, String description);

    Project findProjectById(Long id) throws ProjectNotFoundException;
}
