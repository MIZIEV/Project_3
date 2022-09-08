package com.restservice.dto;

import com.restservice.models.Sensor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementsDTO {

    @Min(value = -60, message = "Min value must be higher than -60")
    @Max(value = 60, message = "Max value must be smaller than 60")
    private int temperature;

    @NotNull
    private boolean isRain;
    @NotNull(message = "Sensor doesn't registered. Register them")
    private Sensor sensor;

    public MeasurementsDTO() {
    }

    public MeasurementsDTO(Sensor sensor, int temperature, boolean isRain) {
        this.sensor = sensor;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}