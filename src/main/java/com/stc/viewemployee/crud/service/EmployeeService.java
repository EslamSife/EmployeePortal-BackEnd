package com.stc.viewemployee.crud.service;


import com.stc.viewemployee.crud.dto.EmployeeDTO;
import com.stc.viewemployee.crud.entity.Employee;
import com.stc.viewemployee.crud.exception.EmployeeNotFoundException;
import com.stc.viewemployee.crud.repository.EmployeeRepository;
import com.stc.viewemployee.crud.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Employee> getAllEmployees(Specification<Employee> spec, Sort sort) {
        return employeeRepository.findAll(spec, sort);
    }


    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(ErrorMessage.EMPLOYEE_NOT_FOUND.getMessage() + id));
    }


    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(ErrorMessage.EMPLOYEE_NOT_FOUND.getMessage() + id);
        }
        employeeRepository.deleteById(id);
    }


    public Employee updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(ErrorMessage.EMPLOYEE_NOT_FOUND.getMessage() + id));
        existingEmployee.setFName(employeeDTO.getFName());
        existingEmployee.setLName(employeeDTO.getLName());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(existingEmployee);
    }


}
