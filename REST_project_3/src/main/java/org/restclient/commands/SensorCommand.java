package org.restclient.commands;

import org.restclient.datagenerator.SensorDataGenerator;
import org.restclient.models.Data;
import org.restclient.models.SensorData;

public class SensorCommand implements Command {

    private SensorData sensorData;
    private final SensorDataGenerator sensorDataGenerator;

    public SensorCommand(SensorData sensorData, SensorDataGenerator sensorDataGenerator) {
        this.sensorData = sensorData;
        this.sensorDataGenerator = sensorDataGenerator;
    }

    @Override
    public Data execute() {
        sensorData = new SensorData(sensorDataGenerator.generate().toString());
        return sensorData;
    }
}