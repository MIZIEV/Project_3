package org.restclient.datagenerator;

import java.util.Random;

public class SensorDataGenerator {

    private Random randomSensorNumber = new Random();
    public StringBuffer generate() {
        StringBuffer standardSensorName = new StringBuffer();
        int randomDigit = randomSensorNumber.nextInt(100);
        standardSensorName.append("Sensor_№").append(randomDigit);
        return standardSensorName;
    }
}