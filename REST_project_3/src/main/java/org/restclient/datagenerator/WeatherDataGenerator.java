package org.restclient.datagenerator;

import org.restclient.models.Data;
import org.restclient.models.SensorData;
import org.restclient.models.WeatherData;

import java.util.Random;

public class WeatherDataGenerator implements DataGenerator {

    private Random randomTemperature = new Random();
    private Random randomSensorNumber = new Random();
    private Random randomBoolean = new Random();

    private WeatherData weatherData;

    @Override
    public Data generate() {
        int randomBetween = randomTemperature.nextInt((50 - (-50)) + 1) + (-50);
        StringBuffer standardSensorName = new StringBuffer();

        int randomDigit = randomSensorNumber.nextInt(100);
        standardSensorName.append("Sensor_№").append(randomDigit);

        weatherData = new WeatherData(
                new SensorData(standardSensorName.toString()),
                (byte) randomBetween,
                randomBoolean.nextBoolean());

        return weatherData;
    }

    @Override
    public String toString() {
        return weatherData.getSensor().getName() + ", temperature" +
                weatherData.getTemperature() + ", isRain: " +
                weatherData.isRain();
    }
}