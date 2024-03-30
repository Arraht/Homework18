package com.example.homework18.controller;

import com.example.homework18.interfaces.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/departments/max-salary")
    public String maxSalaryDepartment(@RequestParam("department") int department) {
        return departmentService.maxSalaryDepartment(department);
    }
    @GetMapping(path = "/departments/min-salary")
    public String minSalaryDepartment(@RequestParam("department") int department) {
        return departmentService.minSalaryDepartment(department);
    }
    @GetMapping(path = "/departments/all/departments")
    public String allEmployeeByDepartment(@RequestParam("department") int department) {
        return departmentService.allEmployeeDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public String allEmployee() {
        return departmentService.allEmployee();
    }
}
