package com.jpwhealth.configuration.exception;

import com.jpwhealth.domain.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Entity entity, Long id) {
        super(String.format("%s not found for id '%s'", entity, id));
    }

    public ResourceNotFoundException(Entity entity, List<Long> ids) {
        super(String.format("%s not found for id '%s'", entity, ids));
    }

}