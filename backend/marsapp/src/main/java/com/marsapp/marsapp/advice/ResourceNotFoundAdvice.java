package com.marsapp.marsapp.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.marsapp.marsapp.exceptions.ResourceNotFoundException;

@RestControllerAdvice
class EmployeeNotFoundAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
        String employeeNotFoundHandler(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
}
