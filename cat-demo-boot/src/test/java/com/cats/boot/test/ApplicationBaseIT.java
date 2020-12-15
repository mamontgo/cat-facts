package com.cats.boot.test;

import com.cats.boot.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationBaseIT extends EnvSettings {


//    private static final String URL = "http://localhost:";
//
//    @LocalServerPort
//    private int randomServerPort;
//
//
//    private RestTemplate template = new RestTemplate();
//
//
//    public RestTemplate getTemplate() {
//        return this.template;
//    }
//
//    public String getUrl() {
//        return URL + randomServerPort + "/";
//    }

}
