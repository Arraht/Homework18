package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeAlreadyAddedException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmployeeStorageIsFullException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static int numberOfEmployees = 10;
    private final Map<Integer, Employee> mapEmployees = new HashMap<>(Map.of(
            1,
            new Employee("Маргарита", "Дмитриевна", 1, 57820, 1),
            2,
            new Employee("Владимир", "Карташов", 2, 35124, 2),
            3,
            new Employee("Арсений", "Иванов", 3, 65482, 3),
            4,
            new Employee("Софья", "Седова", 3, 32579, 4),
            5,
            new Employee("Аврора", "Ершова", 2, 65880, 5),
            6,
            new Employee("Александра", "Ларионова", 1, 75850, 6),
            7,
            new Employee("Максим", "Коровин", 3, 40850, 7),
            8,
            new Employee("Анна", "Кузьмина", 4, 95000, 8),
            9,
            new Employee("Полина", "Селезнева", 2, 50000, 9),
            10,
            new Employee("Милана", "Богданова", 3, 45000, 10)
    ));

    @Override
    public Map<Integer, Employee> getMapEmployee() {
        return mapEmployees;
    }

    @Override
    public String addEmployee(Integer key, Employee employee) {
        if (getMapEmployee().size() >= numberOfEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");
        } else if (getMapEmployee().get(key) != null) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            getMapEmployee().put(key, employee);
            return "Сотрудник " + employee.getFirstName() + " " + employee.getLustName() + " добавлен";
        }
    }

    @Override
    public String removeEmployee(Integer id) {
        if (getMapEmployee().isEmpty()) {
            throw new EmptyListException("Список пуст");
        } else if (getMapEmployee().get(id) != null) {
            String name = getMapEmployee().get(id).toString();
            getMapEmployee().remove(id);
            return "Сотрудник " + name + " удалён";
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
    }

    @Override
    public String searchEmployee(Integer key) {
        if (getMapEmployee().get(key) == null) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        } else {
            return getMapEmployee().get(key).toString();
        }
    }

    @Override
    public Integer num() {
        return getMapEmployee().size();
    }
}