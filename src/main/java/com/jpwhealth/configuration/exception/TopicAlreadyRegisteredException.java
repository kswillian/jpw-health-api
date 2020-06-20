package com.jpwhealth.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TopicAlreadyRegisteredException extends RuntimeException{

    public TopicAlreadyRegisteredException(String topic) {
        super(String.format("Topic with name '%s' already exists.", topic));
    }

}
