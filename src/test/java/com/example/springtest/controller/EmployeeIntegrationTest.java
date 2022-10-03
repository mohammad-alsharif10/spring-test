package com.example.springtest.controller;

import com.example.springtest.entity.Employee;
import com.example.springtest.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class EmployeeIntegrationTest {

    @Autowired
    private EmployeeService employeeService;
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder().age(25).name("Mohammad").salary(2000.0).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveEmployee() {
        var saveEmployee = employeeService.saveEmployee(employee);
        Assertions.assertNotNull(saveEmployee.getId());
    }
}
