package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.interfaces.DepartmentService;
import com.example.homework18.map.MapEmployee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl extends MapEmployee implements DepartmentService {
    @Override
    public String maxSalaryDepartment(int department) {
        return super
                .getEmployees()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary)).toString();
    }

    @Override
    public String minSalaryDepartment(int department) {
        return super
                .getEmployees()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary)).toString();
    }

    @Override
    public String allEmployeeDepartment(int department) {
        return super
                .getEmployees()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList().toString();
    }
    @Override
    public String allEmployee() {
        Map<Integer, List<Employee>> allEmployeeMap = super
                .getEmployees()
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return allEmployeeMap.toString();
    }
}