package com.example.jwtauth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    Long id;
    String name;
    Date deadline;
    String description;
    String flag; //or int for the ID?

    @JsonCreator
    public ProjectDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("deadline") @JsonFormat(pattern = "yyy-MM-dd")Date deadline,
            @JsonProperty("description") String description,
            @JsonProperty("flag") String flag) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.flag = flag;
    }

}
