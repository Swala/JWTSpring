package com.example.jwtauth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FlagDTO {
    Integer id;
    String name;

    @JsonCreator
    public FlagDTO (
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
        }
}

