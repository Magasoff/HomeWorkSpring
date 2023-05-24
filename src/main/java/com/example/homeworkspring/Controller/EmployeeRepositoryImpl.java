package com.example.homeworkspring.Controller;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // Коллекция для имитации данных
    private List<Employee> employees = Arrays.asList(
            new Employee("Екатерина", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));


    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
