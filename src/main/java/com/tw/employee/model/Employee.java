package com.tw.employee.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="employee") // annotation will map our class to the corresponding database table
@Data
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) // primary key of the Entity
    private int id;

    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @NotNull(message = "FirstName cannot be null")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = "LastName cannot be null")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(mappedBy = "employee")
    private Address address;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL) // any operation in general happens on a single entity
    // to allow JPA operate / act on multiple entities or To establish a dependency between related entities,
    // JPA provides javax.persistence.CascadeType enumerated types that define the cascade operations
    private Contact contact;


   /* @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<Recommendation> recommendations;*/

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName) {
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
