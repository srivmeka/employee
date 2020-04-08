package com.tw.employee.repository.impl;

import com.tw.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("employeeDummyRepository")
public class EmployeeDummyRepository {

    static List<Employee> employees = null;
    static int count = 1;
    static String ID_PREFIX = "HYD01XX2019";

    static {
        //Load Dummy Data
        employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setEmployeeId(ID_PREFIX+(count++));
        employee.setFirstName("Sri");
        employee.setLastName("Ch");
        employees.add(employee);

        Employee employee1 = new Employee();
        employee1.setEmployeeId(ID_PREFIX+(count++));
        employee1.setFirstName("Manvith");
        employee.setLastName("Ch");
        employees.add(employee1);
    }


    public List<Employee> findAll() {
        return employees;
    }

    public String create(Employee employee) {
        employee.setEmployeeId(ID_PREFIX+(count++));
        employees.add(employee);
        return employee.getEmployeeId();
    }
}
