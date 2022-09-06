package com.restservice.util.exceptions;

public class SensorNotFoundException extends RuntimeException{

    public SensorNotFoundException(){}

    public SensorNotFoundException(String errorMessage){
        super(errorMessage);
    }
}