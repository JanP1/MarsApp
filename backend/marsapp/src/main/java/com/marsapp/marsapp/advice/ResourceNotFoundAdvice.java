package com.marsapp.marsapp.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.marsapp.marsapp.exceptions.ResourceNotFoundException;

import java.util.Map;

@RestControllerAdvice
class ResourceNotFoundAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> resourceNotFoundHandler(ResourceNotFoundException ex) {

        return Map.of("message", ex.getMessage());
    }
}
