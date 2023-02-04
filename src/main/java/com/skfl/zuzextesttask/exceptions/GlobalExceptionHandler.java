package com.skfl.zuzextesttask.exceptions;

import com.skfl.zuzextesttask.exceptions.custom.CarNotFoundException;
import com.skfl.zuzextesttask.exceptions.custom.CitizenNotFoundException;
import com.skfl.zuzextesttask.exceptions.custom.HouseNotFoundException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchCitizenNotFoundException(CitizenNotFoundException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApplicationError(HttpStatus.NOT_FOUND.value(), "No such citizen found"));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchCarNotFoundException(CarNotFoundException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApplicationError(HttpStatus.NOT_FOUND.value(), "No such car found"));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchHouseNotFoundException(HouseNotFoundException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApplicationError(HttpStatus.NOT_FOUND.value(), "No such house found"));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchValidationException(ValidationException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApplicationError(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchBindException(BindException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApplicationError(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(new ApplicationError(HttpStatus.I_AM_A_TEAPOT.value(), e.getMessage()));
    }

}
