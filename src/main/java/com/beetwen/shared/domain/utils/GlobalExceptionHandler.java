package com.beetwen.shared.domain.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) throws JsonProcessingException {

        Object jsonResponse =  new CustomErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getCause(),
                e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
    }

}

