package com.example.homework18.employee;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lustName;
    private final int department;
    private final int salary;
    private final int id;

    public Employee(String firstName, String lustName, int department, int salary, int id) {
        this.firstName = firstName;
        this.lustName = lustName;
        this.department = department;
        this.salary = salary;
        this.id = id;
    }

    public String getFirstName() {
        if (StringUtils.isEmpty(firstName)) {
            return "";
        }
        return StringUtils.substring(firstName, 0, 1).toUpperCase()
                + StringUtils.substring(firstName, 1);
    }

    public String getLustName() {
        if (StringUtils.isEmpty(lustName)) {
            return "";
        }
        return StringUtils.substring(lustName, 0, 1).toUpperCase()
                + StringUtils.substring(lustName, 1);
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