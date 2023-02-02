package com.skfl.zuzextesttask.exceptions;

import com.skfl.zuzextesttask.exceptions.custom.CarNotFoundException;
import com.skfl.zuzextesttask.exceptions.custom.CitizenNotFoundException;
import com.skfl.zuzextesttask.exceptions.custom.HouseNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchCitizenNotFoundException(CitizenNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.NOT_FOUND.value(), "No such citizen found")
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchCarNotFoundException(CarNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.NOT_FOUND.value(), "No such car found")
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchHouseNotFoundException(HouseNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.NOT_FOUND.value(), "No such house found")
                , HttpStatus.NOT_FOUND);
    }
}
