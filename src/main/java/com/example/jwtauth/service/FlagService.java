package com.example.jwtauth.service;

import com.example.jwtauth.model.Flag;
import com.example.jwtauth.repository.FlagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlagService {

    private final FlagRepo flagRepo;

    @Autowired
    public FlagService(FlagRepo flagRepo) {
        this.flagRepo = flagRepo;
    }

    public List<Flag> getAll() {
        return flagRepo.findAll();
    }
}
