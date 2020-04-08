package com.tw.employee.repository;


import com.tw.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeJPARepository extends EmployeeRepository, JpaRepository<Employee, Integer> {
    Employee findByEmployeeId(String employeeId);
    Employee findByEmployeeIdLike(String employeeId);

    @Query("from Employee e where e.firstName like %?1%") // Talk about positional params and :name
    List<Employee> findByFirstName(String firstName);
}
