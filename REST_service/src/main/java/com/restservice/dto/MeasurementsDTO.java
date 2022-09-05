package com.restservice.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class MeasurementsDTO {

    @Column(name = "temperature")
    @NotEmpty(message = "The temperature mustn't be empty ")
    private int temperature;

    @Column(name = "is_rain")
    private boolean isRain;

    public MeasurementsDTO(){
    }

    public MeasurementsDTO(int temperature, boolean isRain) {
        this.temperature = temperature;
        this.isRain = isRain;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isRain() {
        return isRain;
    }

    public void setRain(boolean rain) {
        isRain = rain;
    }
}
