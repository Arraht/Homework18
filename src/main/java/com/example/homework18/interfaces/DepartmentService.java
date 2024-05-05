package com.example.homework18.interfaces;

import com.example.homework18.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalaryDepartment(int department);

    int sumSalaryByDepartment(int department);

    Employee minSalaryDepartment(int department);

    List<Employee> allEmployeeDepartment(int department);

    Map<Integer,List<Employee>> allEmployee();
}