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
                              @RequestParam("key") Integer key) {
        try {
            Employee employee = new Employee(firstName, lustName);
            return employeeService.addEmployee(key,employee);
        } catch (EmployeeStorageIsFullException e) {
            return "Превышен лимит сотрудников";
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже есть";
        }
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("key") Integer key) {
        try {
            return employeeService.removeEmployee(key);
        } catch (EmptyListException e) {
            return "Список пуст";
        } catch (EmployeeNotFoundException e) {
            return "Такого сотрудника нет";
        }
    }

    @GetMapping(path = "/find")
    public String searchEmployee(@RequestParam("key") Integer key) {
        try {
            return employeeService.searchEmployee(key);
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