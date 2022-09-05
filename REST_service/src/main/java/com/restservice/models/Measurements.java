package com.restservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "measurements")
public class Measurements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "temperature")
    @NotEmpty(message = "The temperature mustn't be empty ")
    private int temperature;

    @Column(name = "is_rain")
    private boolean isRain;

    public Measurements(){}

    public Measurements(int id, int temperature, boolean isRain) {
        this.id = id;
        this.temperature = temperature;
        this.isRain = isRain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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