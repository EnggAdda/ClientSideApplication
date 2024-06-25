package org.example.clientsideapplication;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.util.Map;

public class CustomClientSideInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.println(request);
        System.out.println("url: " + request.getURI());
        System.out.println("method: " + request.getMethod());
        System.out.println("headers: " + request.getHeaders());

        ClientHttpResponse response ;
          try {
              response = execution.execute(request, body);
          }
           catch (HttpServerErrorException | HttpClientErrorException e) {
               System.out.println(e.getStatusCode());
               System.out.println(e.getMessage());
               throw  e ;
           }
          catch (IOException e) {

              System.out.println("we got the network error and error msg is :- "+e.getMessage());
              throw  e ;
          }
          finally {
              System.out.println("we are in finally block");
          }

           System.out.println(response);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusText());
        System.out.println(response.getBody());
        return response;
    }
}
