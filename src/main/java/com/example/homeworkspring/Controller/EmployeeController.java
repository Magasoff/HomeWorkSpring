package com.example.homeworkspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/salary/sum")
    public double getSalarySum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getEmployeeWithMinSalary();
    }

    @GetMapping("/salary/max")
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> getEmployeesWithHighSalary() {
        return employeeService.getEmployeesWithHighSalary();
    }
    @PostMapping("/")
    public ResponseEntity<Void> createEmployees(@RequestBody List<Employee> employees) {
        employeeService.createEmployees(employees);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (!id.equals(employee.getId())) {
            return ResponseEntity.badRequest().build();
        }
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/salaryHigherThan")
    public ResponseEntity<List<Employee>> getEmployeesWithSalaryGreaterThan(@RequestParam Integer salary) {
        List<Employee> employees = employeeService.getEmployeesWithSalaryGreaterThan(salary);
        return ResponseEntity.ok(employees);
    }
}
