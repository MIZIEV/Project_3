package org.restclient.restconverter;

import org.restclient.commands.Command;
import org.restclient.models.Data;
import org.restclient.models.SensorData;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RESTClient {

    private Command command;
    private final String url;

    public RESTClient(Command command, String url) {
        this.command = command;
        this.url = url;
    }

    public void createJSONPostQuery(int count) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse=null;

        int localVar = 0;
        while (localVar < count) {
            try {
                HttpEntity<Data> request = new HttpEntity<>(command.execute());


                System.out.println(restTemplate.postForEntity(url, request, SensorData.class));

                localVar++;
            } catch (RestClientException e) {
                continue;
            }
        }
    }

}
