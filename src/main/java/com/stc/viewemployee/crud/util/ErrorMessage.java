package com.stc.viewemployee.crud.util;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    EMPLOYEE_NOT_FOUND("Employee not found with id: ");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}