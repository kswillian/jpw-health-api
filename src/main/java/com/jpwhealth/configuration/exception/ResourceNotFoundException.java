package com.jpwhealth.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String model, Long id) {
        super(String.format("%s not found for id '%s'", model, id));
    }

    public ResourceNotFoundException(String model, List<Long> ids) {
        super(String.format("%s not found for id '%s'", model, ids));
    }

}