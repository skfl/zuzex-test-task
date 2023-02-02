package com.skfl.zuzextesttask.exceptions.custom;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
