package com.example.springtest.service;

import com.example.springtest.entity.Employee;
import com.example.springtest.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;


    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder().age(25).name("Mohammad").salary(2000.0).build();
    }

    @Test
    void saveEmployee() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Assertions.assertEquals(employee, employeeService.saveEmployee(employee));
    }

    @Test
    void refuseEmployeeWhenAgelessThan18() {
        Assertions.assertFalse(employeeService.isValidEmployeeAge(17));
    }

    @Test
    void refuseEmployeeWhenAgeBiggerThan50() {
        Assertions.assertFalse(employeeService.isValidEmployeeAge(55));
    }

    @Test
    void acceptEmployeeWhenAgeBiggerThan17OrLessThan50() {
        Assertions.assertTrue(employeeService.isValidEmployeeAge(25));
    }




}
