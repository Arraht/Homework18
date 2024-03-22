package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeAlreadyAddedException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmployeeStorageIsFullException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int numberOfEmployees = 10;
    private Map<Integer, Employee> employees = new HashMap(Map.of(
            1,
            new Employee("Маргарита", "Дмитриевна"),
            2,
            new Employee("Владимир", "Карташов"),
            3,
            new Employee("Арсений", "Иванов"),
            4,
            new Employee("Софья", "Седова"),
            5,
            new Employee("Аврора", "Ершова"),
            6,
            new Employee("Александра", "Ларионова"),
            7,
            new Employee("Максим", "Коровин"),
            8,
            new Employee("Анна", "Кузьмина"),
            9,
            new Employee("Полина", "Селезнева"),
            10,
            new Employee("Милана", "Богданова")
    ));

    @Override
    public String addEmployee(Integer key, Employee employee) {
        if (employees.size() >= numberOfEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");
        } else if (employees.get(key) != null) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            employees.put(key, employee);
            return "Сотрудник " + employee.getFirstName() + " " + employee.getLustName() + " добавлен";
        }
    }

    @Override
    public String removeEmployee(Integer key) {
        if (employees.isEmpty()) {
            throw new EmptyListException("Список пуст");
        } else if (employees.get(key) != null) {
            String name = employees.get(key).toString();
            employees.remove(key);
            return "Сотрудник " + name + " удалён";
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
    }

    @Override
    public String searchEmployee(Integer key) {
        if (employees.get(key) == null) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        } else {
            return employees.get(key).toString();
        }
    }

    @Override
    public Integer num() {
        return employees.size();
    }
}