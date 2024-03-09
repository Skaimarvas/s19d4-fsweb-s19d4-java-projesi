package com.example.s19d4.controller;

import com.example.s19d4.entity.Employee;
import com.example.s19d4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id){
        return employeeService.findById(id);
    }

    @GetMapping("/byorder")
    public List<Employee> lastNameByOrder(){
        return employeeService.listByOrder();
    }
    @GetMapping("/email/{email}")
    public Employee findByEmail(@PathVariable String email){
        return employeeService.findByEmail(email);
    }
    @GetMapping("/salary/{salary}")
    public List<Employee> findBySalary(@PathVariable Integer salary){
        return employeeService.findBySalary(salary);
    }

    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable long id){
        return employeeService.remove(id);
    }


}
