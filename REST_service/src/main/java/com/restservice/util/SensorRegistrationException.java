package com.restservice.util;

public class SensorRegistrationException extends RuntimeException{

    public SensorRegistrationException(){}

    public SensorRegistrationException(String errorMessage){
        super(errorMessage);
    }
}