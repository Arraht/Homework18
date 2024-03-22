package com.example.homework18.interfaces;

import com.example.homework18.employee.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployee(Employee employee);

    String removeEmployee(Employee employee);

    String searchEmployee(Employee employee);

    Integer num();
}
