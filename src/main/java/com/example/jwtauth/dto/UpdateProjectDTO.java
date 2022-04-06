package com.example.jwtauth.dto;

import com.example.jwtauth.model.Flag;
import lombok.Value;

import java.util.Date;

@Value
public class UpdateProjectDTO {
    String name;
    Date deadline;
    String description;
    Integer flagId;
}
