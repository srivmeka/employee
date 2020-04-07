package com.tw.employee.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Address {
    private int id;
    private String street;
    private String city;
    private String state;
    private String zipCode;


}
