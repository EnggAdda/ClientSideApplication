package org.example.clientsideapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class StudentService {

    public static final String url = "http://localhost:8081/server";

    @Autowired
    private RestTemplate   restTemplate;

    public Map<String ,Object> getStudentDetails() {

        HttpEntity <Map<String ,Object>> httpEntity = new HttpEntity<Map<String ,Object>>(getHeaders());

        var  response  =restTemplate.exchange(url, HttpMethod.GET , httpEntity , Map.class);
   return  response.getBody();
    }

    public HttpHeaders  getHeaders() {
        HttpHeaders  httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("username", "abc");
        return httpHeaders;
    }
}
