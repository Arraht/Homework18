package com.example.homework18.interfaces;

import com.example.homework18.employee.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployee(Integer key,Employee employee);

    String removeEmployee(Integer key);

    String searchEmployee(Integer key);

    Integer num();
}
