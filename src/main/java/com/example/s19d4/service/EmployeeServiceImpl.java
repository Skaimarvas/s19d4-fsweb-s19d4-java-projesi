package com.example.s19d4.service;

import com.example.s19d4.entity.Employee;
import com.example.s19d4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }



    @Override
    public Optional<Employee> findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> findBySalary(Integer salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if(foundEmployee.isPresent()){
            return foundEmployee.get();
        }
        return null;
    }

    @Override
    public List<Employee> listByOrder() {
        return employeeRepository.orderByLastName();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee remove(long id) {
        Employee employee = findById(id);

        if(employee != null){
            employeeRepository.delete(employee);

            return employee;
        }
        return null;
    }
}
