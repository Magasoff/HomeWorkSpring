package com.example.homeworkspring.Controller;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    void save(Employee employee);
    void deleteById(Long id);
    List<Employee> findBySalaryGreaterThan(Integer salary);
}
