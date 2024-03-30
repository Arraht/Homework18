package com.example.homework18.employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lustName;
    private int department;
    private int salary;
    private int id;

    public Employee(String firstName, String lustName, int department, int salary, int id) {
        this.firstName = firstName;
        this.lustName = lustName;
        this.department = department;
        this.salary = salary;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLustName() {
        return lustName;
    }

    public int getDepartment() {
        return department;
    }


    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return department == employee.department && salary == employee.salary && id == employee.id
                && Objects.equals(firstName, employee.firstName) && Objects.equals(lustName, employee.lustName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lustName, department, salary, id);
    }

    public String toString() {
        return this.firstName + " " + this.lustName + " salary = " + this.salary + " id = " + this.id + " отдел = " +
                this.department;
    }
}