package com.example.homeworkspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

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

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesWithSalaryAbove(Integer salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public Employee createEmployee(Employee employee) {
        employee.setId(null);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(newEmployee.getName());
            employee.setLastName(newEmployee.getLastName());
            employee.setPosition(newEmployee.getPosition());
            employee.setSalary(newEmployee.getSalary());
            employeeRepository.save(employee);
            return employee;
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

