package com.example.jwtauth.repository;
import com.example.jwtauth.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepo extends JpaRepository <Project, Long> {

    Optional<Project> findByName(String name);
}
