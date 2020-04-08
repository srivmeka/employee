package com.tw.employee.repository.impl;
import com.tw.employee.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository extends BaseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(final Contact contact) {
        final String sql = "insert into contact (email_id, phone_number) values (?, ?)";
        return create(new String[]{contact.getEmailId(), String.valueOf(contact.getPhoneNumber())}, sql);
    }
}
