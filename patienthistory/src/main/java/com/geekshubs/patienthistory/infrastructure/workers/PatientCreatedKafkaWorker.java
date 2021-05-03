package com.geekshubs.patienthistory.infrastructure.workers;

import com.geekshubs.patienthistory.domain.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PatientCreatedKafkaWorker {

    Logger log = LoggerFactory.getLogger(PatientCreatedKafkaWorker.class);

    @KafkaListener(topics = "patients")
    public void consume(Patient message) {
        log.info("Mensaje recibido ->" + message.toString());
    }
}
