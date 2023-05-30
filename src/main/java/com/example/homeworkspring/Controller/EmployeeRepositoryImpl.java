package com.example.homeworkspring.Controller;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<Long, Employee> employees = new HashMap<>();
    private Long nextId = 1L;

    // Коллекция для имитации данных
    private List<Employee> employee = Arrays.asList(
            new Employee(1L,"Екатерина", "2",90_000),
            new Employee(2L,"Дима", "3", 102_000),
            new Employee(3L,"Олег", "4",80_000),
            new Employee(4L,"Вика", "5",165_000));

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
    @Override
    public Employee findById(Long id) {
        return employees.get(id);
    }

    @Override
    public void save(Employee employee) {
        employee.setId(nextId++);
        employees.put(employee.getId(), employee);
    }

    @Override
    public void update(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void deleteById(Long id) {
        employees.remove(id);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Integer salary) {
        return employees.values().stream().filter(e -> e.getSalary().compareTo(salary) > 0).collect(Collectors.toList());}
}




