package com.example.homeworkspring.Controller;

public class Employee {
    private String name;
    private String lastName;
    private int salary;
    private long id;
    private String position;

    public Employee(String name, String lastName, int salary, long id, String position) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.id = id;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}





