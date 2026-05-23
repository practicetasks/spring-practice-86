package com.example.springpractice86.controller;

import com.example.springpractice86.model.Employee;
import com.example.springpractice86.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        log.info("Получен запрос на создание сотрудника {}", employee);
        return employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(@RequestParam(required = false) String position,
                                       @RequestParam(required = false) String name) {
        log.info("Получен запрос на получени списка сотрудников");
        return employeeService.getEmployees(position, name);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        log.info("Получен запрос на получение сотрудника по id={}", id);
        return employeeService.getById(id);
    }
}
