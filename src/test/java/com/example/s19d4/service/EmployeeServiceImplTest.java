package com.example.s19d4.service;

import com.example.s19d4.entity.Employee;
import com.example.s19d4.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**Todo:
 * isSaved methodları tekrar gözden geçirilecek konuyu pekiştirmek babında
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeServiceImpl(employeeRepository);

    }

    @DisplayName("findAll method run succesfully")
    @Test
    void findAll(){
        employeeService.findAll();
        verify(employeeRepository).findAll();
    }

    @DisplayName("listByOrder method run succesfully")
    @Test
    void listByOrder(){
        employeeService.listByOrder();
        verify(employeeRepository).orderByLastName();
    }

    @DisplayName("isSaveSucceed method run succesfully")
    @Test
    void isSaveSucceed(){

        Employee employee = new Employee();
        employee.setEmail("em@test.com");
        employee.setFirstName("Empty");
        employee.setLastName("Employee");
        employee.setSalary(10000);

        given(employeeRepository.findByEmail("em@test.com")).willReturn(employee);

        Employee savedEmployee = employeeService.save(employee);

        Employee retrievedEmployee = employeeService.findByEmail("em@test.com");


        assertNotNull(retrievedEmployee);
    }

    @DisplayName("isSaveFailed method failed")
    @Test
    void isSaveFailed(){
        Employee employee = new Employee();
        employee.setEmail("em@test.com");
        employee.setFirstName("Empty");
        employee.setLastName("Employee");
        employee.setSalary(10000);

        Employee saved = employeeService.save(employee);
        assertNull(saved);

    }


}
