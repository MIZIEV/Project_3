package com.restservice.util.exceptions;

public class SensorRegistrationException extends RuntimeException{

    public SensorRegistrationException(){}

    public SensorRegistrationException(String errorMessage){
        super(errorMessage);
    }
}