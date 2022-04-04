package com.example.jwtauth.controller;

import com.example.jwtauth.dto.FlagDTO;
import com.example.jwtauth.dto.ProjectDTO;
import com.example.jwtauth.model.EFlag;
import com.example.jwtauth.model.Flag;
import com.example.jwtauth.model.Project;
import com.example.jwtauth.service.FlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:3000", allowCredentials = "true") //* all origins are allowed origins = "http://localhost:3000", allowCredentials = "true"
@RestController
@RequestMapping("/api/flag")
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @GetMapping("/all")
    public List<FlagDTO> allFlags() {
        return flagService.getAll().stream().map(this::toDTO).collect(Collectors.toList());
    }


    public FlagDTO toDTO(Flag flag) {
        //System.out.println(flag.getName().toString());
        String replacedName = "";
        if (flag.getName().toString().contains("_")) {
            replacedName = replaceSpecialChar(flag.getName());
            return new FlagDTO(
                    flag.getId(),
                    replacedName);

        }else {
            return new FlagDTO(
                    flag.getId(),
                    flag.getName().toString());
        }
    }

    public String replaceSpecialChar(EFlag name) {
        String replaceName = name.toString();
        return replaceName.replace("_", " ");
    }
}
