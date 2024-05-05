package com.example.homework18.controller;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeAlreadyAddedException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmployeeStorageIsFullException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lustName") String lustName,
                              @RequestParam("department") Integer department,
                              @RequestParam("salary") Integer salary,
                              @RequestParam("ID") Integer id) {
        {
            try {
                Employee employee = new Employee(firstName, lustName, department, salary, id);
                return employeeService.addEmployee(id, employee);
            } catch (EmployeeStorageIsFullException e) {
                return "Превышен лимит сотрудников";
            } catch (EmployeeAlreadyAddedException e) {
                return "Такой сотрудник уже есть";
            }
        }
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("id") Integer id) {
        try {
            return employeeService.removeEmployee(id);
        } catch (EmptyListException e) {
            return "Список пуст";
        } catch (EmployeeNotFoundException e) {
            return "Такого сотрудника нет";
        }
    }

    @GetMapping(path = "/find")
    public String searchEmployee(@RequestParam("id") Integer id) {
        try {
            return employeeService.searchEmployee(id);
        } catch (EmptyListException e) {
            return "Список пуст";
        } catch (EmployeeNotFoundException e) {
            return "Такого сотрудника нет";
        }
    }

    @GetMapping(path = "/num")
    public Integer num() {
        return employeeService.num();
    }
}