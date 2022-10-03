package com.example.springtest.service;

import com.example.springtest.entity.Employee;
import com.example.springtest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean isValidEmployeeAge(int age) {
        return age > 17 && age < 50;
    }
}
