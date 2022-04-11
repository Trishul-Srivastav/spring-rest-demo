package com.trishul.springrestdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter

//@NoArgsConstructor
public class EmployeeBean {

    private int empId;
    private String name;
    private long adharNo;
    private double salary;
    private String designation;
}
