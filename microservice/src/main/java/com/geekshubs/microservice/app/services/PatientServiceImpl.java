package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.domain.entities.Patient;
import com.geekshubs.microservice.domain.exceptions.PatientException;
import com.geekshubs.microservice.domain.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Date;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private KafkaTemplate<String, Patient> kafkaTemplate;
    private static final String TOPIC = "patients";

    @Override
    public Patient savePatient(Patient patient) throws PatientException {

        Patient result = null;

        try {
            result = patientRepository.save(patient);
        } catch (Exception e) {
            throw new PatientException(e.getMessage());
        }

        kafkaTemplate.send(TOPIC, result);
        return result;
    }

    @Override
    public Mono<Patient> findPatientByUUID(String uuid) {
        Mono<Patient> monoPatient = Mono.fromCallable(() -> new Patient(
                "pepe",
                "pepe",
                LocalDate.now(),
                new Date()
        ));
        return monoPatient;
    }
}
