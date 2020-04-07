package com.tw.employee.service;

import com.tw.employee.model.Employee;
import com.tw.employee.repository.AddressRepository;
import com.tw.employee.repository.ContactRepository;
import com.tw.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    @Qualifier("employeeJDBCRepository")
    EmployeeRepository employeeRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    AddressRepository addressRepository;

    /*@Autowired
    EmployeeDummyRepository employeeRepository;
     */

    public List<Employee> listEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // any transformations if needed
        return employees;
    }

    public Employee createEmployee(Employee employee) {
        // Create Address - Get AddressId
        int contactId = contactRepository.create(employee.getContact());
        employee.getContact().setId(contactId);

        int addressId = addressRepository.create(employee.getAddress());
        employee.getAddress().setId(addressId);

        // TODO Logic to generate Employee_id  - Business Logic
        employee.setEmployeeId("TWBLRMDP-02"); // TODO remove hardcoding
        int employeeId =  employeeRepository.create(employee);

        return employee;
    }
}
