package com.example.s19d4.repository;

import com.example.s19d4.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

@SpringBootTest
public class EmployeeRepositoryTest {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRepositoryTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @DisplayName(("findById method run succesfully"))
    @Test
    void findByIdSuccess(){
        Optional<Employee> employee = employeeRepository.findById(1l);
        assertNotNull(employee);
        assertEquals(employee.get().getEmail(), "jd@test.com");
        assertEquals(employee.get().getFirstName(),"John");
    }

    @DisplayName("findByEmail method run succesfully")
    @Test
    void findByEmail(){
        Optional<Employee> employee = employeeRepository.findByEmail("rc@test.com");
        assertTrue(employee.isPresent());
        assertNotNull(employee);
        assertEquals(employee.get().getLastName(), "Cabbar");
        assertEquals(employee.get().getFirstName(),"Rıfkı");
    }

    @DisplayName("findById method failure state")
    @Test
    void findByIdFailure(){
        Optional<Employee> employee = employeeRepository.findById(15l);
        assertFalse(employee.isPresent());
    }
}
