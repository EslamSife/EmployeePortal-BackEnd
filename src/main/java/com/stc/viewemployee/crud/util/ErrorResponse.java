package com.stc.viewemployee.crud.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ErrorResponse {

    private String message;
    private List<String> details;

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }
}
