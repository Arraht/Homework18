package com.example.homework18.service;

import com.example.homework18.employee.Employee;
import com.example.homework18.exceptions.EmployeeDepartmentNotFoundException;
import com.example.homework18.exceptions.EmptyListException;
import com.example.homework18.interfaces.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private EmployeeService employeeService;

    private Map<Integer, Employee> employeeMap;

    @BeforeEach
    public void init() {
        employeeMap = new HashMap<>(Map.of(
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
                new Employee("Милана", "Богданова", 3, 45000, 10)));
    }

    @Test
    public void maxSalaryDepartmentTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        Employee employee = departmentService.maxSalaryDepartment(1);
        assertEquals(employeeMap.get(6).getFirstName(), employee.getFirstName());
    }

    @Test
    public void maxSalaryDepartmentNotFoundExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        assertThrows(EmployeeDepartmentNotFoundException.class, () -> departmentService.maxSalaryDepartment(50));
    }

    @Test
    public void maxSalaryDepartmentEmptyListExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        employeeMap.clear();
        assertThrows(EmptyListException.class, () -> departmentService.maxSalaryDepartment(5));
    }

    @Test
    public void sumSalaryByDepartmentTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        assertEquals(133_670, departmentService.sumSalaryByDepartment(1));
    }

    @Test
    public void sumSalaryByDepartmentNotFoundExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        assertThrows(EmployeeDepartmentNotFoundException.class, () -> departmentService.sumSalaryByDepartment(50));
    }

    @Test
    public void sumSalaryByDepartmentEmptyListExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        employeeMap.clear();
        assertThrows(EmptyListException.class, () -> departmentService.sumSalaryByDepartment(2));
    }

    @Test
    public void minSalaryDepartmentTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        Employee employee = departmentService.minSalaryDepartment(3);
        assertEquals(employeeMap.get(4).getFirstName(), employee.getFirstName());
    }

    @Test
    public void minSalaryDepartmentNotFoundExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        assertThrows(EmployeeDepartmentNotFoundException.class, () -> departmentService.minSalaryDepartment(50));
    }

    @Test
    public void minSalaryDepartmentEmptyListExceptionsTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        employeeMap.clear();
        assertThrows(EmptyListException.class, () -> departmentService.minSalaryDepartment(2));
    }

    @Test
    public void allEmployeeDepartmentTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        List<Employee> employeeListTest = departmentService.allEmployeeDepartment(3);
        List<Employee> employeeList = new ArrayList<>(List.of(
                employeeMap.get(3),
                employeeMap.get(4),
                employeeMap.get(7),
                employeeMap.get(10)
        ));
        assertEquals(employeeList, employeeListTest);
    }

    @Test
    public void allEmployeeDepartmentNotFoundExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        assertThrows(EmployeeDepartmentNotFoundException.class, () -> departmentService.allEmployeeDepartment(50));
    }

    @Test
    public void allEmployeeEmptyListExceptionTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        employeeMap.clear();
        assertThrows(EmptyListException.class, () -> departmentService.allEmployeeDepartment(5));
    }

    @Test
    public void allEmployeeTest() {
        when(employeeService.getMapEmployee()).thenReturn(employeeMap);
        Map<Integer, List<Employee>> listMap = employeeMap
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        assertEquals(listMap, departmentService.allEmployee());
    }
}