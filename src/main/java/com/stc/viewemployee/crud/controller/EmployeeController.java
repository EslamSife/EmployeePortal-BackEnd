package com.stc.viewemployee.crud.controller;


import com.stc.viewemployee.crud.dto.EmployeeDTO;
import com.stc.viewemployee.crud.entity.Employee;
import com.stc.viewemployee.crud.repository.EmployeeSort;
import com.stc.viewemployee.crud.repository.EmployeeSpecifications;
import com.stc.viewemployee.crud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class EmployeeController {


    private final EmployeeService employeeService;


    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee savedEmployee = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.ok(savedEmployee);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "sortField", required = false) String sortField,
            @RequestParam(value = "sortDir", required = false) String sortDir) {
        Specification<Employee> spec = EmployeeSpecifications.withDynamicQuery(search);
        Sort sort = EmployeeSort.byFieldAndDirection(sortField, sortDir);
        List<Employee> employees = employeeService.getAllEmployees(spec, sort);
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


    // use custom documentation for Open APi
    @Operation(
            description = "delete endpoint for employee",
            summary = "this a summary for employee delete endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404"
                    )
            }
    )
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

}
