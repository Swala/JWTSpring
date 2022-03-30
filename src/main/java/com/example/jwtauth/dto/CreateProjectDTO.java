package com.example.jwtauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class CreateProjectDTO {
    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    String name;

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    Date deadline;

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    String description;
}
