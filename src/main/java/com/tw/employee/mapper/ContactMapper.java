package com.tw.employee.mapper;

import com.tw.employee.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
       Contact contact = new Contact();
       contact.setId(rs.getInt("contact_id"));
       contact.setEmailId(rs.getString("email_id"));
       contact.setPhoneNumber(rs.getLong("phone_number"));

       return contact;
    }
}
