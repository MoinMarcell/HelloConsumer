package com.github.moinmarcell.helloconsumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HelloService {
    public static final String BASE_URL = "http://localhost:8080";
    private final RestClient restClient;

    public HelloService() {
        this.restClient = RestClient.builder().baseUrl(BASE_URL).build();
    }

    public String fetchHello(String name) {
        return restClient
                .get()
                .uri("/hello?name={name}", name)
                .retrieve()
                .body(String.class);
    }

}
