package com.example.springpractice86.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {
    private Long id;
    private String name;
    private String lastname;
    private String position;
    private LocalDate startedWorkDate;
}
