package com.stc.viewemployee.crud.service;


import com.stc.viewemployee.crud.dto.EmployeeDTO;
import com.stc.viewemployee.crud.entity.Employee;
import com.stc.viewemployee.crud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .fName(employeeDTO.getFName())
                .lName(employeeDTO.getLName())
                .phone(employeeDTO.getPhone())
                .email(employeeDTO.getEmail())
                .salary(employeeDTO.getSalary())
                .build();
        return employeeRepository.save(employee);
    }

}
