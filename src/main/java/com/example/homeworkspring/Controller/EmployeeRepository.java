package com.example.homeworkspring.Controller;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();

    List<Employee> findAll();
}