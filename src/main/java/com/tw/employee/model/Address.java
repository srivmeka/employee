package com.tw.employee.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="address")
@Data
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @OneToOne
    @JoinColumn(name="address_id", nullable=false)
    private Employee employee;


}
