package org.restclient.restconverter;

import org.restclient.datagenerator.DataGenerator;
import org.restclient.models.Data;
import org.restclient.models.SensorData;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RESTClient {

    public void createJSONPostQuery(DataGenerator dataGenerator, String url, int count) {
        RestTemplate restTemplate = new RestTemplate();

        int localVar = 0;
        while (localVar < count) {
            try {
                HttpEntity<Data> request = new HttpEntity<>(dataGenerator.generate());
                System.out.println(restTemplate.postForEntity(url, request, SensorData.class));
            } catch (RestClientException e) {
                e.printStackTrace();
                continue;
            } finally {
                localVar++;
            }
        }
    }

    public String createJSONGetQuery(String url) {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}