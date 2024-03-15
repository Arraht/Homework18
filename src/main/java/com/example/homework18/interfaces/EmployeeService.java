package com.example.homework18.interfaces;

import com.example.homework18.employee.Employee;

public interface EmployeeService {
    String addEmployee(Employee employee);

    String removeEmployee(Employee employee);

    String searchEmployee(Employee employee);

}
