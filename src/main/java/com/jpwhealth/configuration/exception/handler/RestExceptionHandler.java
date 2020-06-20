package com.jpwhealth.configuration.exception.handler;

import com.jpwhealth.configuration.exception.CpfAlreadyRegisteredException;
import com.jpwhealth.configuration.exception.ResourceNotFoundException;
import com.jpwhealth.configuration.exception.ExceptionDetails;
import com.jpwhealth.configuration.exception.TopicAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(ResourceNotFoundException resourceNotFoundException){

        ExceptionDetails exceptionDetails = ExceptionDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(resourceNotFoundException.getMessage())
                .message(resourceNotFoundException.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CpfAlreadyRegisteredException.class)
    public ResponseEntity<?> handleNotFoundException(CpfAlreadyRegisteredException CpfAlreadyRegisteredException){

        ExceptionDetails exceptionDetails = ExceptionDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("CPF already exists")
                .detail(CpfAlreadyRegisteredException.getMessage())
                .message(CpfAlreadyRegisteredException.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TopicAlreadyRegisteredException.class)
    public ResponseEntity<?> handleNotFoundException(TopicAlreadyRegisteredException topicAlreadyRegisteredException){

        ExceptionDetails exceptionDetails = ExceptionDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Topic already exists")
                .detail(topicAlreadyRegisteredException.getMessage())
                .message(topicAlreadyRegisteredException.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleBadRequest(MethodArgumentNotValidException exception){

        List<ExceptionDetails> exceptionDetails = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {

            ExceptionDetails exceptionDetail = ExceptionDetails.Builder
                    .newBuilder()
                    .timestamp(new Date().getTime())
                    .status(HttpStatus.NOT_FOUND.value())
                    .title("Bad request")
                    .detail(
                            String.format(
                                    "The field '%s' %s",
                                    error.getField(),
                                    messageSource.getMessage(error, LocaleContextHolder.getLocale()))
                    )
                    .message(MethodArgumentNotValidException.class.getName())
                    .build();

            exceptionDetails.add(exceptionDetail);

        });

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);

    }

}
