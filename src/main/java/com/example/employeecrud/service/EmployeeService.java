package com.example.employeecrud.service;

import com.example.employeecrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee findById(int id);
    public List<Employee> findAll();
    public void save(Employee employee);
    public void deleteById(int id);
}
