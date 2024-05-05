package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeAlreadyAddedException;
import com.example.homework18.exceptions.EmployeeNotFoundException;
import com.example.homework18.exceptions.EmployeeStorageIsFullException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceImplTest {
    private final EmployeeService service = new EmployeeServiceImpl();

    @BeforeEach
    public void setUp() {
        service.getMapEmployee().clear();
        Map<Integer, Employee> mapEmployeeTest = new HashMap<>(Map.of(
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
        service.getMapEmployee().putAll(mapEmployeeTest);
    }

    @Test
    public void addEmployeeStorageIsFullExceptionTest() {
        assertThrows(EmployeeStorageIsFullException.class, () -> service.addEmployee(11,
                new Employee("Андрей", "Сидоров", 2, 5000, 11)));
    }

    @Test
    public void addEmployeeAlreadyAddedExceptionTest() {
        service.getMapEmployee().remove(10);
        assertThrows(EmployeeAlreadyAddedException.class, () -> service.addEmployee(9,
                new Employee("Полина", "Селезнева", 2, 50000, 9)));
    }

    @Test
    public void addEmployeeTest() {
        service.getMapEmployee().remove(5);
        Employee employeeTest = new Employee("Василий", "Чёрный", 2, 3000, 12);
        service.addEmployee(12, employeeTest);
        assertEquals(employeeTest, service.getMapEmployee().get(12));
    }

    @Test
    public void removeEmployeeEmptyListExceptionTest() {
        service.getMapEmployee().clear();
        assertThrows(EmptyListException.class, () -> service.removeEmployee(2));
    }

    @Test
    public void removeEmployeeTest() {
        service.getMapEmployee().remove(2);
        assertThrows(EmployeeNotFoundException.class, () -> service.removeEmployee(2));
    }

    @Test
    public void searchEmployeeNotFoundExceptionTest() {
        assertThrows(EmployeeNotFoundException.class, () -> service.searchEmployee(36));
    }

    @Test
    public void searchEmployee() {
        assertEquals(service.getMapEmployee().get(5).toString(), service.searchEmployee(5));
    }

    @Test
    public void numTest() {
        assertEquals(10, service.getMapEmployee().size());
    }
}