package com.example.homework18.map;

import com.example.homework18.employee.Employee;

import java.util.HashMap;
import java.util.Map;

public abstract class MapEmployee {
    private Map<Integer, Employee> employees = new HashMap(Map.of(
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
    public Map<Integer, Employee> getEmployees() {
        return employees;
    }
}