package com.example.jwtauth.controller;

import com.example.jwtauth.dto.CreateProjectDTO;
import com.example.jwtauth.dto.ProjectDTO;
import com.example.jwtauth.dto.UpdateProjectDTO;
import com.example.jwtauth.exceptions.ProjectNotFoundException;
import com.example.jwtauth.model.Project;
import com.example.jwtauth.payload.MessageResponse;
import com.example.jwtauth.service.ProjectService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<MessageResponse> createProject(@Valid @RequestBody CreateProjectDTO cProject) {
        System.out.println("projectcontroller");
        try {
            Project project = projectService.createProject(
                    cProject.getName(), cProject.getDeadline(), cProject.getDescription());
            //return ResponseEntity.ok(toDTO(project));
            return ResponseEntity.ok(new MessageResponse("Project added successfully!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Something went wrong"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProjectById(@PathVariable ("id") Long id)  {
        try {
            return ResponseEntity.ok(toDTO(projectService.findProjectById(id)));
        }catch (ProjectNotFoundException e) {
            //return new ResponseEntity<>(new ProjectNotFoundException(id), HttpStatus.NOT_FOUND);
            return ResponseEntity
                    .badRequest().body(new MessageResponse("Error: Project not found."));

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable ("id") Long id, @RequestBody UpdateProjectDTO updateProjectDTO) {
        System.out.println(id);
        try {
            return ResponseEntity.ok(toDTO(projectService.updateProject(
                    id,
                    updateProjectDTO.getName(),
                    updateProjectDTO.getDeadline(),
                    updateProjectDTO.getDescription(),
                    updateProjectDTO.getFlagId())));

        }catch (ProjectNotFoundException e) {
            return ResponseEntity
                    .badRequest().body(new MessageResponse("Error: Project not found with id: " + id));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(("hasRole('ADMIN')"))
    public ResponseEntity<?> deleteProjectById(@PathVariable ("id") Long id) {
        //System.out.println("from controller " + id );
        try {
            projectService.deleteProject(id);
            return ResponseEntity.ok(new MessageResponse("Project was deleted!"));
        }catch (ProjectNotFoundException e) {
            return new ResponseEntity<>(
                    new ProjectNotFoundException(id), HttpStatus.NOT_FOUND);
        }
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
