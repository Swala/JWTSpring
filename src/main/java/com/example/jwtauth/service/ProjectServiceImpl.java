package com.example.jwtauth.service;
import com.example.jwtauth.exceptions.ProjectNotFoundException;
import com.example.jwtauth.model.EFlag;
import com.example.jwtauth.model.Flag;
import com.example.jwtauth.model.Project;
import com.example.jwtauth.repository.FlagRepo;
import com.example.jwtauth.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private FlagRepo flagRepo;

    @Override
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project createProject (String name, Date deadline, String description) {
        Project nProject = new Project(name, deadline, description);
        nProject.setFlag(flagRepo.getById(1)); //always starts with flag UNASSIGNED
        return projectRepo.save(nProject);
    }

    public Project findProjectById(Long id) {
        Optional<Project> optionalProject = Optional.ofNullable(projectRepo.getById(id));

        return optionalProject.get();
    };
}
