package com.tw.employee.dto;

import com.tw.employee.model.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeePage extends Pagination {
    List<Employee> pageContent;
}
