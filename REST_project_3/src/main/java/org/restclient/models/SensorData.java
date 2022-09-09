package org.restclient.models;

public class SensorData implements Data{
    private String name;

    public SensorData(){}
    public SensorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sensor - "+ name;
    }
}