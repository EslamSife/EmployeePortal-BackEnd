package com.stc.viewemployee.crud.repository;

import org.springframework.data.domain.Sort;

public class EmployeeSort {


    private EmployeeSort() {
        throw new IllegalStateException("Utility class");
    }

    public static Sort byFieldAndDirection(String field, String direction) {
        Sort sort = Sort.unsorted();
        if (field != null && direction != null) {
            sort = "asc".equalsIgnoreCase(direction) ? Sort.by(field).ascending() : Sort.by(field).descending();
        }
        return sort;
    }
}
