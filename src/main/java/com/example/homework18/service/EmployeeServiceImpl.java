package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeAlreadyAddedException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmployeeStorageIsFullException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import com.example.homework18.map.MapEmployee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl extends MapEmployee implements EmployeeService {
    private final static int numberOfEmployees = 10;

    @Override
    public String addEmployee(Integer key, Employee employee) {
        if (super.getEmployees().size() >= numberOfEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");
        } else if (super.getEmployees().get(key) != null) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            super.getEmployees().put(key, employee);
            return "Сотрудник " + employee.getFirstName() + " " + employee.getLustName() + " добавлен";
        }
    }

    @Override
    public String removeEmployee(Integer id) {
        if (super.getEmployees().isEmpty()) {
            throw new EmptyListException("Список пуст");
        } else if (super.getEmployees().get(id) != null) {
            String name = super.getEmployees().get(id).toString();
            super.getEmployees().remove(id);
            return "Сотрудник " + name + " удалён";
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
    }

    @Override
    public String searchEmployee(Integer key) {
        if (super.getEmployees().get(key) == null) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        } else {
            return super.getEmployees().get(key).toString();
        }
    }


    @Override
    public Integer num() {
        return super.getEmployees().size();
    }
}