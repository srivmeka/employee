package com.tw.employee.repository;

import com.tw.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDummyRepository {

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        //TODO
        return employees;
    }

    public Employee save(Employee employee) {
        //TODO
        return null;
    }
}
