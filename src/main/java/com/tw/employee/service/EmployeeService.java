package com.tw.employee.service;

import com.tw.employee.dto.EmployeePage;
import com.tw.employee.model.Employee;
import com.tw.employee.repository.EmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeJPARepository employeeRepositoryImpl;

    /*@Autowired
    EmployeeDummyRepository employeeRepository;
     */

    public List<Employee> listEmployees() {
        List<Employee> employees = employeeRepositoryImpl.findAll();
        return employees;
    }

    // TODO Pagination and Sorting support
    public List<Employee> listEmployeesSortById() {
        Sort sort =  Sort.by(Direction.ASC,"employeeId");
        List<Employee> employees = employeeRepositoryImpl.findAll(sort);
        return employees;
    }

    public List<Employee> listEmployeesSortByIdAndName() {
        Sort.Order order1 = new Sort.Order(Direction.ASC, "employeeId");
        Sort.Order order2 = new Sort.Order(Direction.ASC, "firstName");
        List<Employee> employees = employeeRepositoryImpl.findAll(Sort.by(order1, order2));
        return employees;
    }

    public EmployeePage listPageEmployees(int pageSize, int page) { // Should return PaginationDTO populating all page related stuff along with
        Sort sort =  Sort.by(Direction.ASC,"employeeId");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<Employee> employeePage = employeeRepositoryImpl.findAll(pageable);
        EmployeePage empPage = new EmployeePage();
        empPage.setPageContent(employeePage.getContent()); //TODO get other detail from pageable reference and return;
        return empPage;
    }


    public Employee createEmployee(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }
}
