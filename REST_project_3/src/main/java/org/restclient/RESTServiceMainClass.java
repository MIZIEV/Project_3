package org.restclient;

import org.restclient.datagenerator.SensorDataGenerator;
import org.restclient.datagenerator.WeatherDataGenerator;
import org.restclient.models.SensorData;
import org.restclient.restconverter.RESTClient;

public class RESTServiceMainClass {
    public static void main(String[] args) {

        String postSensorUrl="http://localhost:8080/api/sensors/registration";
        String postWeatherDataUrl="http://localhost:8080/api/measurements/add";

        String getAllWeatherData="http://localhost:8080/api/measurements/get";

        SensorDataGenerator sensorDataGenerator = new SensorDataGenerator();
        WeatherDataGenerator weatherDataGenerator = new WeatherDataGenerator();

        RESTClient restClient = new RESTClient();

        restClient.createJSONPostQuery(sensorDataGenerator,postSensorUrl,1000);
        restClient.createJSONPostQuery(weatherDataGenerator,postWeatherDataUrl,1000);

        System.out.println(restClient.createJSONGetQuery(getAllWeatherData));

    }
}