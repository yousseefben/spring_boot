package com.jee.project.Exception;

public class BudgetNotFoundException extends RuntimeException {

    public BudgetNotFoundException(Long id) {
        super("Could not find budget " + id);
    }
}
