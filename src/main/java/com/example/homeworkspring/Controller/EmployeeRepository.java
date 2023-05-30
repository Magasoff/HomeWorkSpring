package com.example.homeworkspring.Controller;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();

    List<Employee> findAll();


    Employee findById(Long id);
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(Long id);
    List<Employee> findBySalaryGreaterThan(Integer salary);
}
