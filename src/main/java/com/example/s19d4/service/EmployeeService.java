package com.example.s19d4.service;

import com.example.s19d4.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> listByOrder();
    Employee findByEmail(String email);

     List<Employee> findBySalary(Integer salary);
    Employee findById(long id);
    Employee save(Employee employee);

    Employee remove(long id);
}
