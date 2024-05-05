package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeDepartmentNotFoundException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.DepartmentService;
import com.example.homework18.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryDepartment(int department) {
        if (employeeService.getMapEmployee().isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (employeeService.getMapEmployee().get(department) == null) {
            throw new EmployeeDepartmentNotFoundException("Department not found");
        } else {
            return employeeService
                    .getMapEmployee()
                    .values()
                    .stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .max(Comparator.comparing(Employee::getSalary))
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        }
    }

    @Override
    public int sumSalaryByDepartment(int department) {
        if (employeeService.getMapEmployee().isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (employeeService.getMapEmployee().get(department) == null) {
            throw new EmployeeDepartmentNotFoundException("Department not found");
        } else {
            return employeeService
                    .getMapEmployee()
                    .values()
                    .stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .mapToInt(Employee::getSalary)
                    .sum();
        }
    }

    @Override
    public Employee minSalaryDepartment(int department) {
        if (employeeService.getMapEmployee().isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (employeeService.getMapEmployee().get(department) == null) {
            throw new EmployeeDepartmentNotFoundException("Department not found");
        } else {
            return employeeService
                    .getMapEmployee()
                    .values()
                    .stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .min(Comparator.comparing(Employee::getSalary))
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        }
    }

    @Override
    public List<Employee> allEmployeeDepartment(int department) {
        if (employeeService.getMapEmployee().isEmpty()) {
            throw new EmptyListException("list is empty");
        } else if (employeeService.getMapEmployee().get(department) != null) {
            return employeeService
                    .getMapEmployee()
                    .values()
                    .stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .toList();
        } else {
            throw new EmployeeDepartmentNotFoundException("Department not found");
        }
    }

    @Override
    public Map<Integer, List<Employee>> allEmployee() {
        return employeeService
                .getMapEmployee()
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}