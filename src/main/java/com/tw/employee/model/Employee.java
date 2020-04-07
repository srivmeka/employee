package com.tw.employee.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Employee {
    private String employeeId;

    @NotNull(message = "FirstName cannot be null")
    private String firstName;

    @NotNull(message = "LastName cannot be null")
    private String lastName;

    private Address address;
    private Contact contact;
    private List<Recommendation> recommendations;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName) {
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
