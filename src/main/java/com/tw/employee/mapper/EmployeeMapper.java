package com.tw.employee.mapper;

import com.tw.employee.model.Address;
import com.tw.employee.model.Contact;
import com.tw.employee.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;


    public EmployeeMapper(AddressMapper addressMapper, ContactMapper contactMapper) {
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
    }


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getString("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setAddress(this.addressMapper.mapRow(rs, rowNum));
        employee.setContact(this.contactMapper.mapRow(rs, rowNum));

        return employee;
    }
}
