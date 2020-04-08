package com.tw.employee.repository.impl;

import com.tw.employee.mapper.AddressMapper;
import com.tw.employee.mapper.ContactMapper;
import com.tw.employee.mapper.EmployeeMapper;
import com.tw.employee.model.Employee;
import com.tw.employee.repository.EmployeeRepository;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository("employeeJDBCRepository")
public class EmployeeJDBCRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional()
    public List<Employee> findAll() {

        String SQL = "select * from employee e, address a, contact c where e.address_id = a.id and e.contact_id = c.id " ;
        List <Employee> employees = jdbcTemplate.query(SQL, new EmployeeMapper(new AddressMapper(), new ContactMapper()));

        return employees;

       /*return jdbcTemplate.query(
                "SELECT * FROM employee",
                (rs, rowNum) -> new Employee(rs.getString("employee_id"), rs.getString("first_name"), rs.getString("last_name"))
        ); // TODO - We can use RowMappers*/


    }

    public int create(final Employee employee) {
        final String sql = "insert into employee (employee_id, first_name, last_name, address_id, contact_id) values (?,?,?,?,?)";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, employee.getEmployeeId());
                ps.setString(2, employee.getFirstName());
                ps.setString(3, employee.getLastName());
                ps.setInt(4, employee.getAddress().getId());
                ps.setInt(5, employee.getContact().getId());
                return ps;
            }
        }, holder);

        return (int) holder.getKeyList().get(0).get("id");

    }
}
