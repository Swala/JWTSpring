package com.example.jwtauth.repository;

import com.example.jwtauth.model.EFlag;
import com.example.jwtauth.model.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FlagRepo extends JpaRepository <Flag, Integer> {
    Optional<Flag> findByName(EFlag name);

    Optional<Flag> save(EFlag name);

}
