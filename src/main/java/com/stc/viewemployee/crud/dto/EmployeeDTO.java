package com.stc.viewemployee.crud.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EmployeeDTO {

    @NotNull(message = "First name must not be null")
    private String fName;
    private String lName;
    private String phone;
    private String email;
    private Double salary;
}