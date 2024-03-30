package com.example.homework18.interfaces;

import com.example.homework18.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    String addEmployee(Integer key, Employee employee);

    String removeEmployee(Integer id);

    String searchEmployee(Integer key);

    Integer num();
}
