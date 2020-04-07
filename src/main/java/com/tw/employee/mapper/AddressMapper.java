package com.tw.employee.mapper;

import com.tw.employee.model.Address;
import com.tw.employee.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {

    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setId(rs.getInt("address_id"));
        address.setStreet(rs.getString("street"));

        return address;
    }
}
