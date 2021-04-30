package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.app.services.factories.FactoryPatients;
import com.geekshubs.microservice.domain.entities.Patient;
import com.geekshubs.microservice.domain.exceptions.PatientException;
import com.geekshubs.microservice.domain.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) throws PatientException {

        try {
            return patientRepository.save(patient);
        } catch (Exception e) {
            throw new PatientException(e.getMessage());
        }
    }

    @Override
    public Mono<Patient> findPatientByUUID(String uuid) {
        return Mono.just(FactoryPatients.toStream().findFirst().get());
    }
}
