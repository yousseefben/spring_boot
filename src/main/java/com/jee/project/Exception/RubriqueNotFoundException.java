package com.jee.project.Exception;

public class RubriqueNotFoundException extends RuntimeException {
    public RubriqueNotFoundException(Long id) {
        super("Could not find compte " + id);
    }
}
