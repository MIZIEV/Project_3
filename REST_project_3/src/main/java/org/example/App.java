package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Alexandr");
        jsonToSend.put("age", "29");

        HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonToSend);

        String url = "https://reqres.in/api/users";
        String testMyUrl="http://localhost:8080/api/hello";

        //String getQuery = restTemplate.postForObject(url,request, String.class);
        //System.out.println(getQuery);

        String getMyQuery = restTemplate.getForObject(testMyUrl,String.class);
        System.out.println("rest response"+getMyQuery);

    }
}