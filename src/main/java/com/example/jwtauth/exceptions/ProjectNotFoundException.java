package com.example.jwtauth.exceptions;

public class ProjectNotFoundException extends Exception {
    public ProjectNotFoundException(Long id) {super((id.toString()));}
}
