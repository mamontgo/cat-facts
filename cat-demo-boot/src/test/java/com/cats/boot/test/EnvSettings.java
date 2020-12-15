package com.cats.boot.test;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

public abstract class EnvSettings {
    private static final String URL = "http://localhost:";

    @LocalServerPort
    private int randomServerPort;


    private RestTemplate template = new RestTemplate();


    public RestTemplate getTemplate() {
        return this.template;
    }

    public String getUrl() {
        return URL + randomServerPort + "/";
    }
}
