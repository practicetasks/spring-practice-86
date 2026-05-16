package com.example.springpractice86.service;

import com.example.springpractice86.exception.NotFoundException;
import com.example.springpractice86.exception.ValidationException;
import com.example.springpractice86.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private long nextId;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getById(long id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new NotFoundException("Сотрудник с id=" + id + " не найден");
    }

    public Employee create(Employee employee) {
        validate(employee);
        employee.setId(++nextId);
        employees.add(employee);
        return employee;
    }

    private static void validate(Employee employee) {
        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new ValidationException("Имя сотрудника не указан");
        }

        if (employee.getLastname() == null || employee.getLastname().isBlank()) {
            throw new ValidationException("Фамилия сотрудника не указан");
        }

        if (employee.getPosition() == null || employee.getPosition().isBlank()) {
            throw new ValidationException("Должность сотрудника не указан");
        }

        if (employee.getStartedWorkDate() == null) {
            throw new ValidationException("Дата начала не указана");
        }

        if (employee.getStartedWorkDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Дата начала работы не должна быть в будущем");
        }
    }
}
