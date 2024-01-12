package com.stc.viewemployee.crud.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EmployeeDTO {
    private String fName;
    private String lName;
    private String phone;
    private String email;
    private Double salary;
}