package com.restservice.util.exceptions;

public class SensorAlreadyExistsException extends RuntimeException{

    public SensorAlreadyExistsException(){}
    public SensorAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
