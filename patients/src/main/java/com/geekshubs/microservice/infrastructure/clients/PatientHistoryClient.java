package com.geekshubs.microservice.infrastructure.clients;

import com.geekshubs.microservice.domain.models.PatientHistory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PatientHistoryClient {

    private WebClient client = WebClient.create("http://localhost:8084/api/v1/patients");

    public Flux<PatientHistory> getAllHistory(final String uuid) {
        return client.get()
                .uri("/getAllHistory/" + uuid)
                .retrieve()
                .bodyToFlux(PatientHistory.class);
    }
}
