package com.restservice.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SensorDTO {
    @NotEmpty(message = "Sensor name mustn't be empty")
    @Size(min = 4,max = 25,message = "Sensor name size must be between 4 and 25 characters!!!")
    private String name;

    public SensorDTO(){}

    public SensorDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}