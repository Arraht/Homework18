package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeAlreadyAddedException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmployeeStorageIsFullException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int numberOfEmployees = 10;
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Маргарита", "Дмитриевна"),
            new Employee("Владимир", "Карташов"),
            new Employee("Арсений", "Иванов"),
            new Employee("Софья", "Седова"),
            new Employee("Аврора", "Ершова"),
            new Employee("Александра", "Ларионова"),
            new Employee("Максим", "Коровин"),
            new Employee("Анна", "Кузьмина"),
            new Employee("Полина", "Селезнева"),
            new Employee("Милана", "Богданова")
    ));

    @Override
    public String addEmployee(Employee employee) {
        if (employees.size() >= numberOfEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            employees.add(employee);
            return "Сотрудник " + employee.getFirstName() + " " + employee.getLustName() + " добавлен";
        }
    }

    @Override
    public String removeEmployee(Employee employee) {
        if (employees.isEmpty()) {
            throw new EmptyListException("Список пуст");
        } else if (employees.contains(employee)) {
            employees.remove(employee);
            return "Сотрудник " + employee.getFirstName() + " " + employee.getLustName() + " удалён";
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
    }

    @Override
    public String searchEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        } else {
            return employee.getFirstName() + " " + employee.getLustName();
        }
    }

    @Override
    public Integer num() {
        return employees.size();
    }
}