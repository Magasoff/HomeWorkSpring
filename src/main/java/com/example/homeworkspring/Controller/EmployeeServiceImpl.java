package com.example.homeworkspring.Controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl extends EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public double getSalarySum() {
        List<Employee> employees = employeeRepository.findAll();
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        List<Employee> employees = employeeRepository.findAll();
        Employee employeeWithMinSalary = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMaxSalary() {
        List<Employee> employees = employeeRepository.findAll();
        Employee employeeWithMaxSalary = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public List<Employee> getEmployeesWithHighSalary() {
        List<Employee> employees = employeeRepository.findAll();
        double avgSalary = getSalarySum() / employees.size();
        List<Employee> employeesWithHighSalary = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() > avgSalary) {
                employeesWithHighSalary.add(employee);
            }
        }
        return employeesWithHighSalary;
    }
}