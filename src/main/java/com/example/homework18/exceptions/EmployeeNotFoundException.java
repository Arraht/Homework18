package com.example.homework18.exceptions;

import com.example.homework18.employee.Employee;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
