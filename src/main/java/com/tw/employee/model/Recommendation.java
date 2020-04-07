package com.tw.employee.model;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Recommendation {
    private String employeeId;

    @FutureOrPresent
    private Date recommendedOn;

    @Size(min = 10, max = 200, message = "Recommendation Text must be between 10 and 200 characters")
    private String content;

    private Contact fromContact; // Recommended person
}
