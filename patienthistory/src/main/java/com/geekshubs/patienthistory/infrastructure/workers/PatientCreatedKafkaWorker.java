package com.geekshubs.patienthistory.infrastructure.workers;

import com.geekshubs.patienthistory.app.services.PatientHistoryService;
import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryException;
import com.geekshubs.patienthistory.domain.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PatientCreatedKafkaWorker {

    Logger log = LoggerFactory.getLogger(PatientCreatedKafkaWorker.class);

    private PatientHistoryService patientHistoryService;

    @Autowired
    public PatientCreatedKafkaWorker(PatientHistoryService patientHistoryService) {
        this.patientHistoryService = patientHistoryService;
    }

    @KafkaListener(topics = "patients")
    public void consume(Patient patient) throws PatientHistoryException {
        log.info("Mensaje recibido ->" + patient.toString());
        PatientHistory patientHistory = new PatientHistory(
                patient.getName(),
                patient.getLastName(),
                patient.getUuid(),
                "House",
                "Some specialty"
        );

        this.patientHistoryService.save(patientHistory);
    }
}
