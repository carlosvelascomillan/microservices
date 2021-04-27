package com.geekshubs.microservice.greeting.ui.rest;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${spring.application.name}")
    private String appName;
    private final EurekaClient eurekaClient;

    public GreetingController(@Lazy final EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @GetMapping("/greeting")
    public String greeting() {

        final Application app = eurekaClient.getApplication(appName);
        int size = app.size();
        return "Hola Mundo -> " + app.getName() + ", size -> " + size;
    }
}
