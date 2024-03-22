package com.example.homework18.employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lustName;

    public Employee(String firstName, String lustName) {
        this.firstName = firstName;
        this.lustName = lustName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLustName() {
        return lustName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lustName, employee.lustName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lustName);
    }
}