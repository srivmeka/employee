package com.tw.employee.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class BaseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

     int create(String[] values, String sql) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int count = 1;
            for (String value: values) {
                ps.setString(count++, value);
            }
            return ps;
        }, holder);

        return (int) holder.getKeyList().get(0).get("id");
    }
}
