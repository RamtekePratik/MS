package com.mastercard.demo.demo.exceptionhandlers;


import org.apache.hc.core5.http.HttpStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
@Component
@ControllerAdvice
public class GlobleExceptionHandler {


    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<String> handleSQLException()
    {
        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Data Access Exception Thrown");
    }
}
