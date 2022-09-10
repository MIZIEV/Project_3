package org.restclient.datagenerator;

import org.restclient.models.SensorData;

import java.util.Random;

public class SensorDataGenerator implements DataGenerator{

    private Random randomSensorNumber = new Random();

    @Override
    public SensorData generate() {
        SensorData sensorData = new SensorData();
        StringBuffer standardSensorName = new StringBuffer();

        int randomDigit = randomSensorNumber.nextInt(500);
        standardSensorName.append("Sensor_№").append(randomDigit);
        sensorData.setName(standardSensorName.toString());

        return sensorData;
    }
}