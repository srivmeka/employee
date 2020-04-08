package com.tw.employee.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="contact")
@Data
public class Contact {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "phone_number", nullable = false)
    private long phoneNumber;

    @OneToOne
    @JoinColumn(name="contact_id", nullable=false)
    private Employee employee;

}
