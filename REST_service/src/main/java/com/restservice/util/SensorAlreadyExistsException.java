package com.restservice.util;

public class SensorAlreadyExistsException extends RuntimeException{

    public SensorAlreadyExistsException(){}
    public SensorAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
