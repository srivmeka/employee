package com.tw.employee.service;

import com.tw.employee.model.Employee;
import com.tw.employee.repository.EmployeeDummyRepository;
import com.tw.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    //@Autowired
    //EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDummyRepository employeeRepository;

    public List<Employee> listEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // any transformations if needed
        return employees;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
