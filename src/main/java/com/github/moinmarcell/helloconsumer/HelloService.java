package com.github.moinmarcell.helloconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HelloService {
    public String BASE_URL;
    private final RestClient restClient;

    public HelloService(@Value("${helloproducer.url}") String baseUrl) {
        this.BASE_URL = baseUrl;
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
