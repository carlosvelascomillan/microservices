package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.domain.entities.Patient;
import com.geekshubs.microservice.domain.exceptions.PatientException;
import reactor.core.publisher.Mono;

public interface PatientService {

    Patient savePatient(Patient patient) throws PatientException;

    Mono<Patient> findPatientByUUID(final String uuid);
}
