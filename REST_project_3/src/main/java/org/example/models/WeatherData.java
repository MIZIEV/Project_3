package org.example.models;

public class WeatherData {
    private byte temperature;
    private boolean isRain;

    public WeatherData(){}

    public WeatherData(byte temperature, boolean isRain) {
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
}