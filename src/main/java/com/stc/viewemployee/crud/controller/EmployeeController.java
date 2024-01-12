package com.stc.viewemployee.crud.controller;


import com.stc.viewemployee.crud.dto.EmployeeDTO;
import com.stc.viewemployee.crud.entity.Employee;
import com.stc.viewemployee.crud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;


    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee savedEmployee = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.ok(savedEmployee);
    }
}
