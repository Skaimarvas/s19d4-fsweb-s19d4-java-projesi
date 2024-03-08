package com.example.s19d4.service;

import com.example.s19d4.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(long id);
    Employee save(Employee employee);

    Employee remove(long id);
}
