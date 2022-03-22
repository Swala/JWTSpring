package com.example.jwtauth.controller;

import com.example.jwtauth.dto.CreateProjectDTO;
import com.example.jwtauth.dto.ProjectDTO;
import com.example.jwtauth.model.Project;
import com.example.jwtauth.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600) //* all origins are allowed
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/all")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody CreateProjectDTO cProject) {
        try {
            Project project = projectService.createProject(
                    cProject.getName(), cProject.getDeadline(), cProject.getDescription());
            return ResponseEntity.ok(toDTO(project));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ProjectDTO toDTO(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDeadline(),
                project.getDescription(),
                project.getFlag().toString());
        //getGroups().stream().map(id ->  groupRemote.getNameById(id)).collect(Collectors.toList())//handle null exeption
    }
}
