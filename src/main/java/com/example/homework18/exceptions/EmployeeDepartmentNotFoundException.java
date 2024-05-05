package com.example.homework18.exceptions;

public class EmployeeDepartmentNotFoundException extends RuntimeException {
    public EmployeeDepartmentNotFoundException(String massage) {
        super(massage);
    }
}