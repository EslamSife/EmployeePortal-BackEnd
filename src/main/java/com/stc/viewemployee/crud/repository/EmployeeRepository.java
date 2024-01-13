package com.stc.viewemployee.crud.repository;

import com.stc.viewemployee.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "employeesList", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}