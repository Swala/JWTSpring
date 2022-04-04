package com.example.jwtauth.controller;

import com.example.jwtauth.dto.CreateProjectDTO;
import com.example.jwtauth.dto.ProjectDTO;
import com.example.jwtauth.exceptions.ProjectNotFoundException;
import com.example.jwtauth.model.Project;
import com.example.jwtauth.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:3000", allowCredentials = "true") //* all origins are allowed, origins = "*",
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
    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody CreateProjectDTO cProject) {
        try {
            Project project = projectService.createProject(
                    cProject.getName(), cProject.getDeadline(), cProject.getDescription());
            return ResponseEntity.ok(toDTO(project));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> findProjectById(@PathVariable ("id") Long id) throws ProjectNotFoundException {
        System.out.println("from controller " + id );
        return ResponseEntity.ok(toDTO(projectService.findProjectById(id)));
    }

    public ProjectDTO toDTO(Project project) {
        //System.out.println(project.getFlag().getName().toString());
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDeadline(),
                project.getDescription(),
                project.getFlag().getName().toString());
    }
}
