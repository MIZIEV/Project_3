package com.restservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "measurement")
public class Measurements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "temperature")
    //@NotEmpty(message = "The temperature mustn't be empty ")
    private int temperature;

    @Column(name = "is_rain")
    private boolean isRain;

    @ManyToOne
    @JoinColumn(name = "sensor_id",referencedColumnName = "id")
    private Sensor sensor;

    public Measurements(){}

    public Measurements(Sensor sensor, int temperature, boolean isRain) {
        this.sensor=sensor;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}