package com.jpwhealth.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CpfAlreadyRegisteredException extends RuntimeException{

    public CpfAlreadyRegisteredException(String cpf) {
        super(String.format("Family with cpf '%s' already exists", cpf));
    }

}
