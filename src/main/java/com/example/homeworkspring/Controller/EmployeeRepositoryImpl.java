package com.example.homeworkspring.Controller;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // Коллекция для имитации данных
    private List<Employee> employees = Arrays.asList(
            new Employee("Екатерина", "Пивоварова",90000, 1,"A"),
            new Employee("Дима", "Мапин",102000,2,"B"),
            new Employee("Олег", "Курпин", 45000, 3, "C"),
            new Employee("Вика", "Зайцева",165_000, 4, "D"));


    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Integer salary) {
        return null;
    }
}