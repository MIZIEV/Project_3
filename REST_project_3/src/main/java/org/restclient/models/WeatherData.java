package org.restclient.models;

public class WeatherData implements Data {
    private byte temperature;
    private boolean isRain;

    private SensorData sensor;

    public WeatherData() {
    }

    public WeatherData(SensorData sensor, byte temperature, boolean isRain) {
        this.sensor = sensor;
        this.temperature = temperature;
        this.isRain = isRain;
    }

    public byte getTemperature() {
        return temperature;
    }

    public void setTemperature(byte temperature) {
        this.temperature = temperature;
    }

    public boolean isRain() {
        return isRain;
    }

    public void setRain(boolean rain) {
        isRain = rain;
    }

    public SensorData getSensor() {
        return sensor;
    }

    public void setSensor(SensorData sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return sensor.getName()+")  Temperature -" + temperature + ", is rain: " + isRain;
    }
}