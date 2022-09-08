package com.restservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "measurement")
public class Measurements implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "temperature")
    @Min(value = -60,message = "Min value must be higher than -60")
    @Max(value = 60,message = "Man value must be smaller than 60")
    private int temperature;

    @Column(name = "is_rain")
    private boolean isRain;

    @ManyToOne
    @JoinColumn(name = "sensor_id",referencedColumnName = "id")
    @JsonBackReference
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

    @Override
    public String toString() {
        return id+") "+temperature+", "+" is rain - "+isRain;
    }
}