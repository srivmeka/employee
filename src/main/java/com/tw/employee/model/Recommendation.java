package com.tw.employee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@JsonIgnoreProperties({"employee"}) // this can break the infinite recursion when applied on BACk reference java beans.
//// Can also be done using @JsonManagedReference, @JsonBackReference
public class Recommendation {
    /*@JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name="employee_id")
    private Employee employee;*/

    @FutureOrPresent
    private Date recommendedOn;

    @Size(min = 10, max = 200, message = "Recommendation Text must be between 10 and 200 characters")
    private String content;

    private Contact fromContact; // Recommended person


}
